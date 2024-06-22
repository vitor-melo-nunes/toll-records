package br.com.vitormelonunes.toll_records.adapters.inbound.controller;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;
import br.com.vitormelonunes.toll_records.application.model.TollRecordStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class TollRecodResponse {

    private Long tollRecordId;
    private String licensePlateNumber;
    private String tagNumber;
    private String tagValidationCode;
    private BigDecimal amount;
    private TollRecordStatus status;
    private Instant creationDate;
    private Instant updateDate;

    public Long getTollRecordId() {
        return tollRecordId;
    }

    public void setTollRecordId(Long tollRecordId) {
        this.tollRecordId = tollRecordId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public String getTagValidationCode() {
        return tagValidationCode;
    }

    public void setTagValidationCode(String tagValidationCode) {
        this.tagValidationCode = tagValidationCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TollRecordStatus getStatus() {
        return status;
    }

    public void setStatus(TollRecordStatus status) {
        this.status = status;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    public TollRecodResponse(TollRecord tollRecord) {
        this.tollRecordId = tollRecord.getTollRecordId();
        this.licensePlateNumber = tollRecord.getLicensePlateNumber();
        this.tagNumber = tollRecord.getTagNumber();
        this.tagValidationCode = tollRecord.getTagValidationCode();
        this.amount = tollRecord.getAmount();
        this.status = tollRecord.getStatus();
        this.creationDate = tollRecord.getCreationDate();
        this.updateDate = tollRecord.getUpdateDate();
    }
}