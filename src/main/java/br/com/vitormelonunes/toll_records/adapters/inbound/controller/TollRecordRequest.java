package br.com.vitormelonunes.toll_records.adapters.inbound.controller;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class TollRecordRequest {

    @NotBlank(message = "License plate number is mandatory.")
    private String licensePlateNumber;

    @NotBlank(message = "Tag number is mandatory.")
    private String tagNumber;

    @NotBlank(message = "Tag validation code is mandatory.")
    private String tagValidationCode;

    @NotNull(message = "Amount is mandatory.")
    private BigDecimal amount;

    public TollRecord mapToRequestModel() {
        return new TollRecord(
                this.licensePlateNumber,
                this.tagNumber,
                this.tagValidationCode,
                this.amount);
    }

    public @NotBlank(message = "License plate number is mandatory.") String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(@NotBlank(message = "License plate number is mandatory.") String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public @NotBlank(message = "Tag number is mandatory.") String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(@NotBlank(message = "Tag number is mandatory.") String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public @NotBlank(message = "Tag validation code is mandatory.") String getTagValidationCode() {
        return tagValidationCode;
    }

    public void setTagValidationCode(@NotBlank(message = "Tag validation code is mandatory.") String tagValidationCode) {
        this.tagValidationCode = tagValidationCode;
    }

    public @NotNull(message = "Amount is mandatory.") BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "Amount is mandatory.") BigDecimal amount) {
        this.amount = amount;
    }
}
