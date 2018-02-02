package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "policy_agent", schema = "cyberlife")
@Data
public class PolicyAgent {

	@Id
	private Integer policyAgentId;
	
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Party clientId;
	
	private String primaryProducerFlag;
	
	private String topProducerFlag;
	private String primaryServicingAgentFlag;
	private String servicingAgentFlag;
	private String writingAgentFlag;
	private Double commissionPercentage;
	private String levelNumber;
	private String updatedBy;
	private String updatedWhen;
	private String trailComm;
	private String agentProfile;
	private String marketingOrg;

}
