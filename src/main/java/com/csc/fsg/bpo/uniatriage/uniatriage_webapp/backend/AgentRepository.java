package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Agent;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Policy;

public interface AgentRepository extends CrudRepository<Agent, String> {

	Collection<Agent> findByPolicies(Collection<Policy> policies);

}
