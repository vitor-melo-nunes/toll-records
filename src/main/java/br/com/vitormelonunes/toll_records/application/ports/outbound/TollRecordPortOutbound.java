package br.com.vitormelonunes.toll_records.application.ports.outbound;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;

public interface TollRecordPortOutbound {
    TollRecord saveTollRecord(TollRecord tollRecord) throws Exception;
    TollRecord getTollRecordByTollRecordId(Long tollRecordId) throws Exception;
}
