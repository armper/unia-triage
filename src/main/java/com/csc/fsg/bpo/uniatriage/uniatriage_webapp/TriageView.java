package com.csc.fsg.bpo.uniatriage.uniatriage_webapp;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend.AgentRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend.CoverageRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend.PartyRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend.PolicyAgentRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend.PolicyRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend.StrategyRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Agent;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Coverage;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Party;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Policy;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.PolicyAgent;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Strategy;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import lombok.extern.log4j.Log4j;

@Log4j
@UIScope
@SpringView(name = TriageView.VIEW_NAME)
public class TriageView extends Triage implements View {

	public final static String VIEW_NAME = "TriageView";

	private static final long serialVersionUID = 5793648302221770318L;

	private final PolicyRepository policyRepository;

	private final AgentRepository agentRepository;

	private final PolicyAgentRepository policyAgentRepository;

	private final PartyRepository partyRepository;

	private final StrategyRepository strategyRepository;

	private final CoverageRepository coverageRepository;

	private Collection<Policy> policies = new HashSet<>();

	private ListDataProvider<Policy> policyDataProvider = DataProvider.ofCollection(policies);

	private Collection<Agent> agents = new HashSet<>();

	private ListDataProvider<Agent> agentDataProvider = DataProvider.ofCollection(agents);

	private Collection<PolicyAgent> policyAgents = new HashSet<>();

	private ListDataProvider<PolicyAgent> policyToAgentProvider = DataProvider.ofCollection(policyAgents);

	private Collection<Strategy> strategies = new HashSet<>();

	private ListDataProvider<Strategy> stragegyProvider = DataProvider.ofCollection(strategies);

	private Collection<Coverage> coverages = new HashSet<>();

	private ListDataProvider<Coverage> coverageProvider = DataProvider.ofCollection(coverages);

	@Autowired
	public TriageView(PolicyRepository policyRepository, AgentRepository agentRepository,
			PolicyAgentRepository policyAgentRepository, PartyRepository partyRepository,
			StrategyRepository strategyRepository, CoverageRepository coverageRepository) {
		this.policyRepository = policyRepository;
		this.agentRepository = agentRepository;
		this.policyAgentRepository = policyAgentRepository;
		this.partyRepository = partyRepository;
		this.strategyRepository = strategyRepository;
		this.coverageRepository = coverageRepository;
	}

	@PostConstruct
	void init() {

		super.policyGrid.setDataProvider(this.policyDataProvider);

		this.policyDataProvider.refreshAll();

		super.agentGrid.addColumn(a -> partyRepository.findOne(a.getClientId()).getFullName())
				.setCaption("Client Name");
		super.agentGrid.addColumn(a -> partyRepository.findOne(a.getClientId()).getEmailAddress())
				.setCaption("Email Address");

		super.agentGrid.setDataProvider(this.agentDataProvider);

		super.policyToAgentGrid.addColumn(p -> p.getClientId().getFullName()).setCaption("Client Name");

		super.policyToAgentGrid.setDataProvider(this.policyToAgentProvider);

		super.stragegyGrid.setDataProvider(this.stragegyProvider = DataProvider.ofCollection(strategies));

		super.coverageGrid.setDataProvider(this.coverageProvider);

		super.policyGrid.addSelectionListener(listener -> {

			this.agents.clear();

			this.policyAgents.clear();

			this.strategies.clear();

			this.coverages.clear();

			listener.getFirstSelectedItem().ifPresent(policy -> {
				this.agents.addAll(this.agentRepository.findByPolicy(policy));
				this.policyAgents.addAll(this.policyAgentRepository.findByPolicy(policy));
				this.strategies.addAll(this.strategyRepository.findByPolicy(policy));
				this.coverages.addAll(this.coverageRepository.findByPolicy(policy));
			});

			this.agentDataProvider.refreshAll();
			this.policyToAgentProvider.refreshAll();
			this.stragegyProvider.refreshAll();
			this.coverageProvider.refreshAll();

		});

		super.agentGrid.addSelectionListener(listener -> {
			listener.getFirstSelectedItem().ifPresent(agent -> {

				log.debug(agent.getClientId());

				Party party = partyRepository.findOne(agent.getClientId());

				Collection<Party> parties = new HashSet<>();
				parties.add(party);
				super.partyGrid.setItems(parties);

				log.debug(party.getFullName());
			});
		});

		super.policyNumberTextField.addValueChangeListener(listener -> {
			this.policies.clear();
			Collection<Policy> findByPolicyNumber = this.policyRepository
					.findByPolicyNumberStartingWithIgnoreCase(listener.getValue());
			this.policies.addAll(findByPolicyNumber);
			this.policyDataProvider.refreshAll();

		});
	}

	public PolicyRepository getPolicyRepository() {
		return policyRepository;
	}

}
