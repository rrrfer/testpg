package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.model.*;

public interface PriceListRepository extends CrudRepository<PriceList, String> {
	List<PriceList> findByDescription(String description);

	Optional<PriceList> findById(String id);
}