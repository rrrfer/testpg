package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.model.*;

//!TODO: pretty, but not working with custom controller
//@RepositoryRestResource(collectionResourceRel = "pricelistversion", path = "pricelistversion")
public interface PriceListVersionRepository extends CrudRepository<PriceListVersion, String> {
	List<PriceListVersion> findByIsActive(Boolean isActive);

	Optional<PriceListVersion> findById(String id);
	
	List<PriceListVersion> findByPriceListCodeAndIsActive(@Param("code") String code, @Param("isActive") Boolean isActive);
}