package org.bobpark.domain.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.bobpark.domain.asset.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
