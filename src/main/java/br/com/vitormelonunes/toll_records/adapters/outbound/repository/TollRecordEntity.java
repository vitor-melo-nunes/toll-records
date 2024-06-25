package br.com.vitormelonunes.toll_records.adapters.outbound.repository;

import java.time.Instant;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;
import br.com.vitormelonunes.toll_records.application.model.TollRecordStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@Table(name = "toll_records_tb")
public class TollRecordEntity {

    public TollRecordEntity() {
    }

    public TollRecordEntity(TollRecord tollRecord) {
        this.licensePlateNumber = tollRecord.getLicensePlateNumber();
        this.tagNumber = tollRecord.getTagNumber();
        this.tagValidationCode = tollRecord.getTagValidationCode();
        this.amount = tollRecord.getAmount();
        this.status = tollRecord.getStatus();
        this.creationDate = tollRecord.getCreationDate();
        this.updateDate = tollRecord.getUpdateDate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tollRecordId;

    @NotBlank
    private String licensePlateNumber;

    @NotBlank
    private String tagNumber;

    @NotBlank
    private String tagValidationCode;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TollRecordStatus status;

    @NotNull
    private Instant creationDate;

    @NotNull
    private Instant updateDate;

    public Long getTollRecordId() {
        return tollRecordId;
    }

    public void setTollRecordId(Long tollRecordId) {
        this.tollRecordId = tollRecordId;
    }

    public @NotBlank String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(@NotBlank String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public @NotBlank String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(@NotBlank String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public @NotBlank String getTagValidationCode() {
        return tagValidationCode;
    }

    public void setTagValidationCode(@NotBlank String tagValidationCode) {
        this.tagValidationCode = tagValidationCode;
    }

    public @NotNull @Positive BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@NotNull @Positive BigDecimal amount) {
        this.amount = amount;
    }

    public @NotNull TollRecordStatus getStatus() {
        return status;
    }

    public void setStatus(@NotNull TollRecordStatus status) {
        this.status = status;
    }

    public @NotNull Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(@NotNull Instant creationDate) {
        this.creationDate = creationDate;
    }

    public @NotNull Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(@NotNull Instant updateDate) {
        this.updateDate = updateDate;
    }
}
