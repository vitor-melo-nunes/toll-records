package br.com.vitormelonunes.toll_records.adapters.outbound.message;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;
import br.com.vitormelonunes.toll_records.application.ports.outbound.TollRecordPublisherPortOutbound;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class TollRecordMessageAdapterOutbound implements TollRecordPublisherPortOutbound {

    private final TollRecordTopicMessage tollRecordTopicMessage;
    private final ObjectMapper objectMapper;

    public TollRecordMessageAdapterOutbound(ObjectMapper objectMapper, TollRecordTopicMessage tollRecordTopicMessage) {
        this.objectMapper = objectMapper;
        this.tollRecordTopicMessage = tollRecordTopicMessage;
    }

    @Override
    public void publishTollRecordCreated(TollRecord tollRecord) throws Exception {

        String messagePayload = this.objectMapper.writeValueAsString(tollRecord);

        this.tollRecordTopicMessage.sendNotification("arn:aws:sns:sa-east-1:000000000000:toll-records-created", messagePayload);
    }
}
