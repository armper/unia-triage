package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "strategy", schema = "cyberlife")
@Data
public class Strategy {
	@Id
	private Integer strategyId;

	private Integer strategyTypeId;

	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;

	private Integer sequenceNumber;

	private BigDecimal currentValue;

	private BigDecimal interestRate;
	private BigDecimal interestCap;
	private BigDecimal parRate;
	private BigDecimal sprdRate;
	private BigDecimal expenseCharge;
	private BigDecimal allocationPercent;

}
