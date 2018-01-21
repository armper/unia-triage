package com.csc.fsg.bpo.uniatriage.uniatriage_webapp;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend.AgentRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend.PolicyRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Agent;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Policy;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;

import lombok.extern.log4j.Log4j;

@Log4j
@UIScope
@SpringView(name = TriageView.VIEW_NAME)
public class TriageView extends Triage implements View {

	public final static String VIEW_NAME = "TriageView";

	private static final long serialVersionUID = 5793648302221770318L;

	private final PolicyRepository policyRepository;

	private final AgentRepository agentRepository;

	private Collection<Policy> policies = new HashSet<>();

	private ListDataProvider<Policy> policyDataProvider = DataProvider.ofCollection(policies);

	private Collection<Agent> agents = new HashSet<>();

	private ListDataProvider<Agent> agentDataProvider = DataProvider.ofCollection(agents);

	@Autowired
	public TriageView(PolicyRepository policyRepository, AgentRepository agentRepository) {
		this.policyRepository = policyRepository;
		this.agentRepository = agentRepository;
	}

	@PostConstruct
	void init() {

		super.policyGrid.addColumn(Policy::getPolicyNumber);

		super.policyGrid.setDataProvider(this.policyDataProvider);

		Collection<Policy> findAll = (Collection<Policy>) this.policyRepository.findAll();

		findAll.forEach(f -> log.debug(f));

		policies.addAll(findAll);

		this.policyDataProvider.refreshAll();

		super.agentGrid.addColumn(Agent::getClientId);

		super.agentGrid.setDataProvider(this.agentDataProvider);

		Collection<Agent> findAllAgents = (Collection<Agent>) this.agentRepository.findAll();

		// agents.addAll(findAllAgents);

		// this.agentDataProvider.refreshAll();

		super.policyGrid.addSelectionListener(listener -> {
			log.info("pushed");
			this.agents = new HashSet<>();
			Collection<Agent> findByPolicies = this.agentRepository.findByPolicies(listener.getAllSelectedItems());
			this.agents.addAll(findByPolicies);
			findByPolicies.forEach(p->log.info("loop "+p));
			
			this.agentDataProvider.refreshAll();
			
			

		});
	}

	public PolicyRepository getPolicyRepository() {
		return policyRepository;
	}

}
