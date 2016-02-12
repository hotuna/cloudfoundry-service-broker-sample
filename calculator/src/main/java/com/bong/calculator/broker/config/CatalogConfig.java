package com.bong.calculator.broker.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.cloud.servicebroker.model.Plan;
import org.springframework.cloud.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfig {

	@Bean
	public Catalog catalog() {
		return new Catalog(Collections.singletonList(new ServiceDefinition(
				"calculator-service-broker", "Calculator",
				"A simple calculator broker implemetation.", true, false, Collections
						.singletonList(new Plan("calculator-plan", "DefaultPlan",
								"This is a default calculator plan.", getPlanMetadata())), Arrays
						.asList("calculator", "document"), getServiceDefinitionMetadata(), null,
				null)));
	}

	private Map<String, Object> getServiceDefinitionMetadata() {
		Map<String, Object> sdMetadata = new HashMap<>();
		sdMetadata.put("displayName", "Calculator");
		sdMetadata.put("imageUrl", "");
		sdMetadata.put("longDescription", "SaaS calculator");
		sdMetadata.put("providerDisplayName", "YSJ");
		sdMetadata.put("documentationUrl", "");
		sdMetadata.put("supportUrl", "");
		return sdMetadata;
	}

	private Map<String, Object> getPlanMetadata() {
		Map<String, Object> planMetadata = new HashMap<>();
		planMetadata.put("costs", getCosts());
		planMetadata.put("bullets", getBullets());
		return planMetadata;
	}

	private List<Map<String, Object>> getCosts() {
		Map<String, Object> costsMap = new HashMap<>();

		Map<String, Object> amount = new HashMap<>();
		amount.put("usd", 0.0);

		costsMap.put("amount", amount);
		costsMap.put("unit", "MONTHLY");

		return Collections.singletonList(costsMap);
	}

	private List<String> getBullets() {
		return Arrays.asList("SaaS calculator for free");
	}

}
