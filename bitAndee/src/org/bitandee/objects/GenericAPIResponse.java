package org.bitandee.objects;

import com.mashape.unirest.http.JsonNode;

public class GenericAPIResponse {

	private JsonNode jsonNode;

	public GenericAPIResponse(JsonNode jsonNode) {
		this.jsonNode = jsonNode;
	}

	public JsonNode getJsonNode() {
		return jsonNode;
	}

}
