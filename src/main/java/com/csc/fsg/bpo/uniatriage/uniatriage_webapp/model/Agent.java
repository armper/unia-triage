package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "agent", schema = "cyberlife")
@Data
@ToString(exclude="policies")
public class Agent implements Serializable{

	private static final long serialVersionUID = -8165798951292606888L;

	@Id	
	private String clientId;

	@NotNull
	private Integer companyId;

	@NotNull
	private String agentNumber;

	private Integer statusId;

	@NotNull
	private Integer regionId;

	@NotNull
	private Integer lkHostSystemId;

	private String updatedBy;

	private String updatedWhen;

	private Integer fkaRegioncode;

	private Integer fkaCompanycode;

	private String agtLegacyId;

	private String agtEliteStatus;

	private String agentNpn;

	@ManyToMany
	@JoinTable(name = "policy_agent", schema = "cyberlife", joinColumns = @JoinColumn(name = "client_id")
	, inverseJoinColumns = @JoinColumn(name = "policy_id")
	)
	private Collection<Policy> policies=new HashSet<>();

}
