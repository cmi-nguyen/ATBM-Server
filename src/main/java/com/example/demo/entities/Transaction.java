package com.example.demo.entities;

import com.example.demo.config.AESEncryption;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer transactionID;

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(int receiverid) {
        this.receiverid = receiverid;
    }

    // Columns

    @Column(name="sender_phone")
    private String senderPhone;

    @Column(name="sender_name")
    private String senderName;

    @Column(name = "receiver_phone")
    private  String receiverPhone;

    @Column(name="receiver_name")
    private String receiverName;

    @Column(name="amount")
    private double amount;

    @Column(name="message")
    private String message;

    @Column(name="otp")
    private  String otp;

    @Column(name="transaction_fee")
    private double transactionFee;

    @Column(name = "transaction_date")
    private Date transactionDate;
    @Column(name = "senderid")
    private int senderId;
    @Column(name="receiverid")
    private  int receiverid;

    public String getAESKey() {
        return AESKey;
    }

    public void setAESKey(String AESKey) {
        this.AESKey = AESKey;
    }

    @Column(name="AESKey")
    private  String AESKey;

}
