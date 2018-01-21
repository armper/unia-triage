package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Entity(name="agent")
@Table(name = "agent", schema = "cyberlife")
@Data
@ToString(exclude="policies")
public class Agent {

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

//	private LocalDateTime updatedWhen;

	private Integer fkaRegioncode;

	private Integer fkaCompanycode;

	private String agtLegacyId;

	private String agtEliteStatus;

	private String agentNpn;
//
	@ManyToMany(mappedBy = "agents")
	private Collection<Policy> policies=new HashSet<>();
}
