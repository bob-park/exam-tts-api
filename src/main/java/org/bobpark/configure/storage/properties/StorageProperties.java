package org.bobpark.configure.storage.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties("storage")
public record StorageProperties(Resource location) {
}
