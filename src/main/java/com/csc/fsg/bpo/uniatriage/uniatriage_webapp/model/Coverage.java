package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "coverage", schema = "cyberlife")
@Data
public class Coverage{
	
	@Id
	private Integer coverageId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;
//	
//	private String baseBenefitFlag;
//	
//	private String phaseInd;
//	
	private BigDecimal premiumAccumulationValue;
	
	private BigDecimal premiumAccumulationRate;
	
//	private Integer coverageStatus;
//	
//	private Integer coverageProductId;
//	
//	private BigDecimal issueAge;
	
	private BigDecimal specifiedAmount;
	
	private BigDecimal numberUnits;
	
	private BigDecimal valuePerUnit;
	
	private Date effectiveDate;
	
	private Date statusDate;
	
	private Date benefitCeaseDate;
	
	private Integer dividendOptionId;
	
//	private BigDecimal accumDividends;
//	
//	private BigDecimal DIVIDEND_INTEREST_RATE;
//	
//	private BigDecimal totalPaidUpAdds;
//	
//	private BigDecimal dividendPurchasedAmount;
//	
//	private BigDecimal dividendLastAmountRecieved;
//	
//	private BigDecimal dividendMaxWithDrawalAmount;
	

/*
 * COVERAGE_ID INTEGER NOT NULL,
	
	LAST_DIVIDEND_CREDIT_DATE DATE,
	DIVIDEND_LAST_TYPE_ID SMALLINT,
	DIVIDEND_DUE_DATE DATE,
	 DECIMAL(12,2),
	 DECIMAL(12,2),
	 DECIMAL(12,2),
	PARTICIPATION_CODE_ID SMALLINT,
	UPDATED_BY VARCHAR(100),
	UPDATED_WHEN TIMESTAMP,
	PLAN_CODE CHAR(6),
	COVSEQNUM INTEGER,
	RIDER_INSURED_NAME VARCHAR(56),
	HEALTH_LIMIT_CODE SMALLINT,
	ACCIDENT_ELIMINATION_PERIOD_ID INTEGER,
	ACCIDENT_LIMIT_ID INTEGER,
	SICKNESS_ELIMINATION_PERIOD_ID INTEGER,
	SICKNESS_LIMIT_ID INTEGER,
	PRODUCT_NAME VARCHAR(90),
	PHASE_IND CHAR(1),
	 DECIMAL(14,2),
	 DECIMAL(5,2),
	CONSTRAINT SQL170210111135310 PRIMARY KEY (COVERAGE_ID)
 */

}
