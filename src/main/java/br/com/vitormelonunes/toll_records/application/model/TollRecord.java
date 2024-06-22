package br.com.vitormelonunes.toll_records.application.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class TollRecord {
    private Long tollRecordId;
    private String licensePlateNumber;
    private String tagNumber;
    private String tagValidationCode;
    private BigDecimal amount;
    private TollRecordStatus status;
    private Instant creationDate;
    private Instant updateDate;

    public TollRecord() {
    }

    public TollRecord(String licensePlateNumber,
                      String tagNumber,
                      String tagValidationCode,
                      BigDecimal amount) {
        this.licensePlateNumber = licensePlateNumber;
        this.tagNumber = tagNumber;
        this.tagValidationCode = tagValidationCode;
        this.amount = amount;
    }

    public TollRecord(Long tollRecordId,
                      String licensePlateNumber,
                      String tagNumber,
                      String tagValidationCode,
                      BigDecimal amount,
                      TollRecordStatus status,
                      Instant creationDate,
                      Instant updateDate) {
        this.tollRecordId = tollRecordId;
        this.licensePlateNumber = licensePlateNumber;
        this.tagNumber = tagNumber;
        this.tagValidationCode = tagValidationCode;
        this.amount = amount;
        this.status = status;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Long getTollRecordId() {
        return tollRecordId;
    }

    public void setTollRecordId(Long tollRecordId) {
        this.tollRecordId = tollRecordId;
    }

    public  String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber( String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public  String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber( String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public  String getTagValidationCode() {
        return tagValidationCode;
    }

    public void setTagValidationCode( String tagValidationCode) {
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
}

