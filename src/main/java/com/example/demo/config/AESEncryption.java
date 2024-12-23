package com.example.demo.config;

import jakarta.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Value;
import lombok.SneakyThrows;
import org.springframework.util.SerializationUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

public class AESEncryption implements AttributeConverter<Object, String> {

    @Value("${aes.encryption.key}")
    private String encryptionKey;

    private final String encryptionCipher = "AES";

    private Key key;
    private Cipher cipher;

    private Key getKey() {
        if (key == null)
            key = new SecretKeySpec(encryptionKey.getBytes(), encryptionCipher); //TODOS Save encryted AES key to Database
        return key;
    }

    private Cipher getCipher() throws GeneralSecurityException {
        if (cipher == null)
            cipher = Cipher.getInstance(encryptionCipher);
        return cipher;
    }

    private void initCipher(int encryptMode) throws GeneralSecurityException {
        getCipher().init(encryptMode, getKey());
    }

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Object attribute) {
        if (attribute == null)
            return null;

        try {
            initCipher(Cipher.ENCRYPT_MODE);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
        byte[] bytes = SerializationUtils.serialize(attribute);
        try {
            return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public Object convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;
        try {
            initCipher(Cipher.DECRYPT_MODE);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
        byte[] bytes = null;
        try {
            bytes = getCipher().doFinal(Base64.getDecoder().decode(dbData));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
        return SerializationUtils.deserialize(bytes);
    }
}
