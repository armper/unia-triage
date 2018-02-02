package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Policy;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.PolicyAgent;

public interface PolicyAgentRepository extends CrudRepository<PolicyAgent, Integer> {

	Collection<PolicyAgent> findByPolicy(Policy policy);

	
}
