package org.bobpark.domain.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.bobpark.domain.asset.entity.AssetScript;

public interface AssetScriptRepository extends JpaRepository<AssetScript, Long> {
}
