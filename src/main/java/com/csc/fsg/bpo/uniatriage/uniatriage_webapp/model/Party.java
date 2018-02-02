package com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "party", schema = "client")
@Data
public class Party {

	@Id
	private String clientId;
	private Integer clientTypeId;
	private String fullName;
	private String emailAddress;
	private BigDecimal bpoSplitPercentage;
	private String bpoAgentNumber;
	private Integer bpoBeneficiaryTypeId;
	private Integer beneficiaryRelationshipId;

}
/*
 * CLIENT_ID CHAR(40) NOT NULL,
	CLIENT_STATUS INTEGER DEFAULT 0 NOT NULL,
	CLIENT_TYPE_ID INTEGER DEFAULT 1 NOT NULL,
	FULL_NAME CHAR(100),
	GOV_ID CHAR(40),
	GOV_ID_STATUS CHAR(40),
	GOV_ID_TYPE INTEGER,
	SEARCH_FIRST_NAME CHAR(32),
	SEARCH_LAST_NAME CHAR(100),
	SEARCH_COMPANY_NAME CHAR(100),
	SEARCH_ADDRESS_TYPE INTEGER,
	SEARCH_DOB DATE,
	GENDER_ID INTEGER,
	PREFERED_COMM_TYPE INTEGER,
	UPDATED_BY VARCHAR(100),
	UPDATED_WHEN TIMESTAMP,
	BPO_SEARCH_MIDDLE_NAME VARCHAR(50),
	BPO_PHONE_NUMBER VARCHAR(20),
	SUFFIX VARCHAR(50),
	PREFIX VARCHAR(50),
	EMAIL_ADDRESS VARCHAR(120),
	EMAIL_UPDATED_BY VARCHAR(100),
	PHONE_UPDATED_BY VARCHAR(100),
	PHONE_UPDATED_WHEN TIMESTAMP,
	EMAIL_UPDATED_WHEN TIMESTAMP,
	PHONE_EDELIVERY VARCHAR(20),
	AGENT_FLAG CHAR(1) DEFAULT 'N' NOT NULL,
	COVERED_IND SMALLINT,
	E_DELIVERY_INDICATOR VARCHAR(1),
	CONSTRAINT PK_CLIENT PRIMARY KEY (CLIENT_ID)
 */
