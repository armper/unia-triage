package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Policy;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Strategy;

public interface StrategyRepository extends CrudRepository<Strategy, Integer> {

	Collection<Strategy> findByPolicy(Policy policy);

}
