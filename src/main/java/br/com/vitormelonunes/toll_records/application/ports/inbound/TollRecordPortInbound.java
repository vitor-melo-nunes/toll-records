package br.com.vitormelonunes.toll_records.application.ports.inbound;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;

public interface TollRecordPortInbound {
    TollRecord createTollRecord(TollRecord tollRecordToCreate) throws Exception;
    TollRecord getTollRecordByTollRecordId(Long tollRecordId) throws Exception;
}
