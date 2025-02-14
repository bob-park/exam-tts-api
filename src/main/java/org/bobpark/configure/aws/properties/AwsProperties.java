package org.bobpark.configure.aws.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("aws")
public record AwsProperties(String region,
                            String accessKey,
                            String secretKey) {
}
