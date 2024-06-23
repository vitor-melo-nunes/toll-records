package br.com.vitormelonunes.toll_records.adapters.outbound.message;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;
import br.com.vitormelonunes.toll_records.application.ports.outbound.TollRecordPublisherPortOutbound;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sns.core.SnsNotification;
import org.springframework.stereotype.Component;

@Component
public class TollRecordMessageAdapterOutbound implements TollRecordPublisherPortOutbound {

    private final TollRecordTopicMessage tollRecordTopicMessage;

    public TollRecordMessageAdapterOutbound(ObjectMapper objectMapper, TollRecordTopicMessage tollRecordTopicMessage) {
        this.tollRecordTopicMessage = tollRecordTopicMessage;
    }

    @Override
    public void publishTollRecordCreated(TollRecord tollRecord) throws Exception {
        this.tollRecordTopicMessage.sendNotification("arn:aws:sns:sa-east-1:000000000000:toll-records-created",
                SnsNotification.of(tollRecord));
    }
}
