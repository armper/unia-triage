package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Coverage;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Policy;

public interface CoverageRepository extends CrudRepository<Coverage, Integer> {

	Collection<Coverage> findByPolicy(Policy policy);

}
