package org.bitandee.taskmanager;

import org.bitandee.objects.GenericAPIRequest;

public class API_BitAndee {

	private GenericAPIRequest apiRequest;
	
	public API_BitAndee(GenericAPIRequest apiRequest) {
		this.apiRequest = apiRequest;
	}

	public GenericAPIRequest getApiRequest() {
		return apiRequest;
	}
}
