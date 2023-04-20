package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.model.*;

import org.springframework.data.repository.query.Param;

//!TODO: pretty, but not working with custom controller
//@RepositoryRestResource(collectionResourceRel = "pricelist", path = "pricelist")
public interface PriceListRepository extends CrudRepository<PriceList, String> {
	List<PriceList> findByDescription(@Param("description") String description);
	Optional<PriceList> findById(@Param("id") String id);
	
	Long deleteByCode(@Param("code") String code);
    List<PriceList> removeByCode(@Param("code") String code);
}