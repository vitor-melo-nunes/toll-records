package br.com.vitormelonunes.toll_records.adapters.outbound.message;

import io.awspring.cloud.sns.core.SnsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class TollRecordTopicMessage {
    private final SnsTemplate snsTemplate;

    TollRecordTopicMessage(SnsTemplate snsTemplate) {
        this.snsTemplate = snsTemplate;
    }

    void sendNotification(String topicArn, String message) {
       snsTemplate.sendNotification(topicArn, message, null);
    }
}