package org.bitandee.taskmanager;

import java.util.concurrent.Callable;

import org.bitandee.objects.GenericAPIResponse;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import commons.BitAndeeConstants;

public class API_GetMarketSummaries implements Callable<GenericAPIResponse> {

	@Override
	public GenericAPIResponse call() throws Exception {
		HttpResponse<JsonNode> response = Unirest.get(BitAndeeConstants._GET_MARKET_SUMMARIES).asJson();
		return new GenericAPIResponse(response.getBody());
	}
}
