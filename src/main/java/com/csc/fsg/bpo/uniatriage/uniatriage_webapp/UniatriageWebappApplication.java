package com.csc.fsg.bpo.uniatriage.uniatriage_webapp;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.backend.PolicyRepository;
import com.csc.fsg.bpo.uniatriage.uniatriage_webapp.model.Policy;

import lombok.extern.log4j.Log4j;

@Log4j
@SpringBootApplication
public class UniatriageWebappApplication implements CommandLineRunner {

	private final PolicyRepository policyRepository;

	public UniatriageWebappApplication(PolicyRepository policyRepository) {
		this.policyRepository = policyRepository;
		log.debug("policyRepository injected");
}

	public static void main(String[] args) {
		SpringApplication.run(UniatriageWebappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Policy policy = new Policy();
//		policy.setPolicyId(1);
//		policy.setPolicyNumber("AAAA");
//		policy.setCompanyId(100);
//		policy.setRegionId(123);
//		policy.setStatusId(34);
//				
//		this.policyRepository.save(policy);
		
//		log.debug("persisted "+policy);
	}

	public PolicyRepository getPolicyRepository() {
		return policyRepository;
	}
}
