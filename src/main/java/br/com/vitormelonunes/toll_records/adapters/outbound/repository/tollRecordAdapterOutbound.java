package br.com.vitormelonunes.toll_records.adapters.outbound.repository;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;
import br.com.vitormelonunes.toll_records.application.model.TollRecordStatus;
import br.com.vitormelonunes.toll_records.application.ports.outbound.TollRecordPortOutbound;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class tollRecordAdapterOutbound implements TollRecordPortOutbound {

    private final TollRecordRepository tollRecordRepository;

    public tollRecordAdapterOutbound(TollRecordRepository tollRecordRepository) {
        this.tollRecordRepository = tollRecordRepository;
    }

    @Override
    public TollRecord saveTollRecord(TollRecord tollRecord) throws Exception {
        var dateNow = Instant.now();

        tollRecord.setStatus(TollRecordStatus.CREATED);
        tollRecord.setCreationDate(dateNow);
        tollRecord.setUpdateDate(dateNow);

        TollRecordEntity tollRecordToSave = new TollRecordEntity(tollRecord);
        var tollRecordIdSaved = this.tollRecordRepository.save(tollRecordToSave).getTollRecordId();

        tollRecord.setTollRecordId(tollRecordIdSaved);

        return tollRecord;
    }

    @Override
    public TollRecord getTollRecordByTollRecordId(Long tollRecordId) throws Exception {
        TollRecordEntity tollRecordEntityFound = tollRecordRepository.findById(tollRecordId)
                .orElseThrow(EntityNotFoundException::new);

        return new TollRecord(
                tollRecordEntityFound.getTollRecordId(),
                tollRecordEntityFound.getLicensePlateNumber(),
                tollRecordEntityFound.getTagNumber(),
                tollRecordEntityFound.getTagValidationCode(),
                tollRecordEntityFound.getAmount(),
                tollRecordEntityFound.getStatus(),
                tollRecordEntityFound.getCreationDate(),
                tollRecordEntityFound.getUpdateDate()
        );
    }

}
