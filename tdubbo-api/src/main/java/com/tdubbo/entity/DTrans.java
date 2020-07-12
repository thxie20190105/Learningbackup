package com.tdubbo.entity;

import java.io.Serializable;
import java.util.Date;

public class DTrans implements Serializable {
    private Integer id;

    private String amt;

    private Integer payId;

    private String payName;

    private String payBank;

    private String payBankNo;

    private String payBankAddr;

    private Integer recId;

    private String recName;

    private String recNo;

    private String recBank;

    private String recBankNo;

    private String recBankAddr;

    private String remark;

    private Date createDate;

    private Date createTime;

    private Date transDate;

    private String transNo;

    private String transBatch;

    private String transStatus;

    private String currency;

    private String lockNo;

    private String lockStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt == null ? null : amt.trim();
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    public String getPayBank() {
        return payBank;
    }

    public void setPayBank(String payBank) {
        this.payBank = payBank == null ? null : payBank.trim();
    }

    public String getPayBankNo() {
        return payBankNo;
    }

    public void setPayBankNo(String payBankNo) {
        this.payBankNo = payBankNo == null ? null : payBankNo.trim();
    }

    public String getPayBankAddr() {
        return payBankAddr;
    }

    public void setPayBankAddr(String payBankAddr) {
        this.payBankAddr = payBankAddr == null ? null : payBankAddr.trim();
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName == null ? null : recName.trim();
    }

    public String getRecNo() {
        return recNo;
    }

    public void setRecNo(String recNo) {
        this.recNo = recNo == null ? null : recNo.trim();
    }

    public String getRecBank() {
        return recBank;
    }

    public void setRecBank(String recBank) {
        this.recBank = recBank == null ? null : recBank.trim();
    }

    public String getRecBankNo() {
        return recBankNo;
    }

    public void setRecBankNo(String recBankNo) {
        this.recBankNo = recBankNo == null ? null : recBankNo.trim();
    }

    public String getRecBankAddr() {
        return recBankAddr;
    }

    public void setRecBankAddr(String recBankAddr) {
        this.recBankAddr = recBankAddr == null ? null : recBankAddr.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    public String getTransBatch() {
        return transBatch;
    }

    public void setTransBatch(String transBatch) {
        this.transBatch = transBatch == null ? null : transBatch.trim();
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getLockNo() {
        return lockNo;
    }

    public void setLockNo(String lockNo) {
        this.lockNo = lockNo == null ? null : lockNo.trim();
    }

    public String getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(String lockStatus) {
        this.lockStatus = lockStatus == null ? null : lockStatus.trim();
    }
}