package org.bitandee.objects;

import java.util.LinkedHashMap;
import java.util.Map;

public class GenericAPIRequest {

	private Map<String, String> paramMap = new LinkedHashMap<>();

	public void addParam(String param, String value) {
		getParamMap().put(param, value);
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}
	
	public String getParam(String param) {
		return paramMap.get(param);
	}
}
