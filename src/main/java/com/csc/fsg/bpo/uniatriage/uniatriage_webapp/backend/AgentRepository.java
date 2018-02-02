package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Agent;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Policy;

public interface AgentRepository extends CrudRepository<Agent, String> {

	@Query("SELECT agent FROM Agent agent where :policy member of agent.policies ")
	Collection<Agent> findByPolicy(@Param("policy") Policy policy);
}
