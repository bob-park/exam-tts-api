package org.bobpark.configure.aws;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;

import org.bobpark.configure.aws.properties.AwsProperties;

@RequiredArgsConstructor
@EnableConfigurationProperties(AwsProperties.class)
@Configuration
public class AwsConfiguration {

    private final AwsProperties properties;

    @Bean
    public BedrockRuntimeClient bedrockRuntimeClient() {

        AwsBasicCredentials credentials =
            AwsBasicCredentials.create(properties.accessKey(),
                properties.secretKey());

        return BedrockRuntimeClient.builder()
            .region(Region.of(properties.region()))
            .credentialsProvider(() -> credentials)
            .build();
    }
}
