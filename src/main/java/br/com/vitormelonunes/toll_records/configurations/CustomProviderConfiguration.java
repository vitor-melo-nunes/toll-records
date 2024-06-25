package br.com.vitormelonunes.toll_records.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

import java.net.URI;

@Configuration
public class CustomProviderConfiguration {

    @Bean
    public AwsCredentialsProvider customAwsCredentialsProvider() {
        return StaticCredentialsProvider.create(AwsBasicCredentials.create("test", "test"));
    }

    @Bean
    public SnsClient snsClient(AwsCredentialsProvider awsCredentialsProvider) {
        return SnsClient.builder()
                .credentialsProvider(awsCredentialsProvider)
                .region(Region.of("sa-east-1"))
                .endpointOverride(URI.create("http://localhost:4566"))
                .build();
    }
}