package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "policy", schema = "cyberlife")
@ToString(exclude = "agents")

public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyId;

	@NotNull
	private Integer companyId;

	@NotNull
	private String policyNumber;

	@NotNull
	private Integer regionId;

	private Integer statusId;

	private BigDecimal faceAmount;

	private Date lastActgActivityDate;

	private Date contractActivityDate;

	private Date premiumPaidToDate;

	private Date issueDate;
	
	private String lifeInsuranceTestMethod;
	
	private BigDecimal initialDepositPremium;
	
	private Integer retirementAge;
	
	private BigDecimal maxLoanAmount;
	
	// ISSUE_STATE_CODE_ID SMALLINT,
	// TAX_QUALIFICATION_CODE_ID SMALLINT,
	// PREMIUM_MODE_ID SMALLINT,
	// MODAL_PREMIUM DECIMAL(12 , 2),
	// GROSS_ANNUAL_PREMIUM DECIMAL(12 , 2),
	// POLICY_FEE DECIMAL(12 , 2),
	// DEATH_BENEFIT_OPTION_ID SMALLINT,
	// NON_FORFEITURE_OPTION_ID SMALLINT,
	// NET_AMOUNT_AT_RISK DECIMAL(14 , 2),
	// SURRENDER_VALUE DECIMAL(14 , 2),
	// SURRENDER_FEE DECIMAL(14 , 2),
	// GROSS_CASH_VALUE DECIMAL(14 , 2),
	// FUND_INTEREST_RATE DECIMAL(8 , 5),
	// FUND_GUAR_INTEREST_RATE DECIMAL(8 , 5),
	// PREMIUM_BALANCE_DUE DECIMAL(12 , 2),
	// EFFECTIVE_QUOTE_DATE DATE,
	// EST_DEATH_BENEFIT DECIMAL(14 , 2),
	// BILLING_FORM_ID SMALLINT,
	// BILLING_STATUS_ID SMALLINT,
	// BILLED_THRU_DATE DATE,
	// LAST_PREMIUM_PAID_DATE DATE,
	// GROUP_BILLING_NUMBER VARCHAR(11),
	// MAX_LOAN_AMOUNT DECIMAL(12 , 2),
	// EXIT_CODE_ID SMALLINT,
	// PRODUCT_TYPE_ID INTEGER,
	// PRODUCT_SUBTYPE_ID INTEGER,
	// ARCHIVED SMALLINT NOT NULL,
	// HOST_KEY VARCHAR(60) NOT NULL,
	// LK_HOST_SYSTEM_ID INTEGER NOT NULL,
	// SPECIAL_BILLING_FREQUENCY_ID SMALLINT,
	// NO_BILLING_FLAG CHAR(1),
	// LAST_PREMIUM_APL_FLAG CHAR(1),
	// LAST_PREMIUM_PAID_AMOUNT DECIMAL(14 , 2),
	// LOAN_INTEREST_CHARGE_TYPE_ID SMALLINT,
	// LOAN_INTEREST_RATE DECIMAL(8 , 5),
	// LOAN_PAYOFF_AMOUNT DECIMAL(14 , 2),
	// LOAN_TYPE_ID SMALLINT,
	// LOAN_OUTSTANDING_AMOUNT DECIMAL(14 , 2),
	// SUSPENSE_AMOUNT DECIMAL(14 , 2),
	// GRACE_PERIOD_EXPIRE_DATE DATE,
	// UPDATED_BY VARCHAR(100),
	// UPDATED_WHEN TIMESTAMP,
	// FKA_COMPANY_ID SMALLINT,
	// PLAN_MNEMONIC CHAR(10),
	// ANN_QUAL CHAR(1),
	// BEAGLE_IND CHAR(2),
	// COSTBASIS DECIMAL(19 , 4),
	// IRS_SECTION CHAR(1),
	// RESTRICT_CODE CHAR(1),
	// LETTER_HEAD_CO CHAR(1),
	// ANN_QUAL_AV INTEGER,
	// IRS_SECTION_AV INTEGER,
	// RESTRICT_CODE_AV INTEGER,
	// HDVFLAG SMALLINT,
	// FKA_REGIONCODE SMALLINT,
	// FKA_COMPANYCODE SMALLINT,
	// MAJOR_LOB CHAR(1),
	// RPS_PAYMENT_MODE CHAR(1),
	// RPS_PAYMENT_STATUS CHAR(1),
	// NEXT_PAYMENT_DATE DATE,
	// LAST_PAYMENT_DATE DATE,
	// ASSIGNMENTCODE INTEGER,
	// REINSTATEMENT_DATE DATE,
	// LOAN_PAYMENT_AMT DECIMAL(14 , 2),
	// LOAN_DATE DATE,
	// LOAN_PAYOFF_AMT DECIMAL(14 , 2),
	// MONTHLY_INCOME DECIMAL(12 , 2),
	// REPORTING_LOB INTEGER,
	// LOAN_PAYOFF_DATE DATE,
	// REINSTATEMENTDATE DATE,
	// DISCLOSURE_FLAG CHAR(1),
	// SIGNATURE_FLAG CHAR(1),
	// EDELIVERY_ID CHAR(1),
	// LEAD_ID VARCHAR(25),
	// EDELIVERY_IND CHAR(1),
	// NET_CASH_VAL DECIMAL(11 , 2),
	// FLAT_EXTRA_PERCENT DECIMAL(6 , 2),
	// ACCT_VAL DECIMAL(11 , 2),
	// TOT_PREM_PAID DECIMAL(11 , 2),
	// LAST_DIV_DT DATE,
	// LAST_DIV_AMT DECIMAL(12 , 2),
	// ACCT_NUMBER VARCHAR(4),
	// ACCT_TYPE VARCHAR(1),
	// GUAR_WPREM DECIMAL(11 , 2),
	// GUIDELINE_ACCUM DECIMAL(12 , 2),
	// GUIDELINE_LEVEL DECIMAL(12 , 2),
	// GUIDELINE_SINGLE DECIMAL(12 , 2),
	// LAST_PREM_PYMT_ACT_TYPE VARCHAR(2),
	// MEC_IND VARCHAR(1),
	// PREFRD_LOAN_BAL DECIMAL(12 , 2),
	// REINS_IND INTEGER,
	// SEVEN_PAY_PREM DECIMAL(12 , 2),
	// TEN_THRITYFIVE_COST_BASIS DECIMAL(12 , 2),
	// GUAR_WPREM_DATE DATE,
	// CURR_WPREM_DATE DATE,
	// GUAR_BNOPREM_DATE DATE,
	// CURR_NOPREM_DATE DATE,
	// COMM_TARGET_PREM DECIMAL(11 , 2),
	// AS_OF_DATE DATE,
	// CVC_INDICATOR INTEGER,
	// MAX_PREFRD_LOAN_AMOUNT DECIMAL(12 , 2),
	// BULK_CODE VARCHAR(6),
	// AFFINITY_GROUP_CODE VARCHAR(8),
	// APPLICATION_ID VARCHAR(20),
	// HOUSEHOLD_ID VARCHAR(10),
	// CHANNEL_TYPE_ID INTEGER,
	// IS_BUNDLE VARCHAR(1),
	// BRANDING_CODE VARCHAR(2),
	// ISWL_IND SMALLINT,
	// ADMIN_PROCESSING_COMPANY_CODE VARCHAR(3),
	// ADMIN_PROCESSING_POLICY_KEY CHAR(14),
	// FUND_CODE VARCHAR(2),
	// EFFECTIVE_DATE DATE,
	// BILLING_AMOUNT DECIMAL(12 , 2),
	// COST_OF_INSURANCE DECIMAL(12 , 2),
	// MAX_WITHDRAWL_AMOUNT DECIMAL(12 , 2),
	// MIN_LOAN_AMOUNT DECIMAL(12 , 2),
	// PRIOR_PLAN_CODE VARCHAR(9),

	private BigDecimal marketValueAdjustmentAmount;

	private BigDecimal bonusVestedAccountValue;

	private BigDecimal bonusNonvestedAccountValue;

	private BigDecimal bonusTotalAccountValue;

	private BigDecimal freeWithdrawlAmount;

	@ManyToMany(mappedBy = "policies")
	private Collection<Agent> agents = new HashSet<>();

}
