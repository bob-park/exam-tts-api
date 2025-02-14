package org.bobpark.configure.storage;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import org.bobpark.configure.storage.properties.StorageProperties;

@RequiredArgsConstructor
@EnableConfigurationProperties(StorageProperties.class)
@Configuration
public class StorageConfiguration {
}
