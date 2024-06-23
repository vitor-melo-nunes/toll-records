package br.com.vitormelonunes.toll_records.application.service;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;
import br.com.vitormelonunes.toll_records.application.ports.inbound.TollRecordPortInbound;
import br.com.vitormelonunes.toll_records.application.ports.outbound.TollRecordPortOutbound;
import br.com.vitormelonunes.toll_records.application.ports.outbound.TollRecordPublisherPortOutbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TollRecordService implements TollRecordPortInbound {


    private final TollRecordPublisherPortOutbound tollRecordPublisherPortOutbound;
    private final TollRecordPortOutbound tollRecordPortOutbound;

    public TollRecordService(TollRecordPublisherPortOutbound tollRecordPublisherPortOutbound, TollRecordPortOutbound tollRecordPortOutbound) {
        this.tollRecordPublisherPortOutbound = tollRecordPublisherPortOutbound;
        this.tollRecordPortOutbound = tollRecordPortOutbound;
    }

    @Override
    public TollRecord createTollRecord(TollRecord tollRecordToCreate) throws Exception {
         TollRecord tollRecordCreated = this.tollRecordPortOutbound.saveTollRecord(tollRecordToCreate);
         this.tollRecordPublisherPortOutbound.publishTollRecordCreated(tollRecordCreated);
         return tollRecordCreated;
    }

    @Override
    public TollRecord getTollRecordByTollRecordId(Long tollRecordId) throws Exception {
        return this.tollRecordPortOutbound.getTollRecordByTollRecordId(tollRecordId);
    }

}
