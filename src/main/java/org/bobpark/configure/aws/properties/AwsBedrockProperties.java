package org.bobpark.configure.aws.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("aws.bedrock")
public record AwsBedrockProperties(String modelId) {
}
