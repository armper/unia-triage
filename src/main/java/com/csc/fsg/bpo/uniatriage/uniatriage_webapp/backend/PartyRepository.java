package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend;

import org.springframework.data.repository.CrudRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Party;

public interface PartyRepository extends CrudRepository<Party, String> {

	
}
