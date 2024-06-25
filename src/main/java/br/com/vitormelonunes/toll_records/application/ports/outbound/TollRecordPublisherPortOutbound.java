package br.com.vitormelonunes.toll_records.application.ports.outbound;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;

public interface TollRecordPublisherPortOutbound {
    void publishTollRecordCreated(TollRecord tollRecord) throws Exception;
}
