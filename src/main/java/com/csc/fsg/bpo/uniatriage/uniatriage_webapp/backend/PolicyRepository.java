package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Policy;

public interface PolicyRepository extends CrudRepository<Policy, Integer> {

	//Query q = this.em.createQuery("SELECT o FROM Order o JOIN FETCH o.items i WHERE o.id = :id");

//	@Query("select p from policy p left join fetch p.agents a")
//	public Collection<Policy> findAllEager();
}
