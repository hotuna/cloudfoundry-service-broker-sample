package com.bong.calculator.broker.service;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

import com.bong.calculator.model.UserManager;

@Service
public class BindService implements ServiceInstanceBindingService {

	@Autowired
	private UserManager userManager;

	@Override
	public CreateServiceInstanceBindingResponse createServiceInstanceBinding(
			CreateServiceInstanceBindingRequest request) {
		String appId = request.getBindingId();
		String id = request.getServiceInstanceId();
		String apikey = userManager.getAPIKey(id, appId);
		Map<String, Object> credentials = Collections.singletonMap("APIKEY", (Object) apikey);

		return new CreateServiceInstanceBindingResponse(credentials);
	}

	@Override
	public void deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest request) {
		userManager.deleteUser(request.getServiceInstanceId());
	}

}
