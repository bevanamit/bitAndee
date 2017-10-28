package org.bitandee.taskmanager;

import java.util.concurrent.Callable;

import org.bitandee.objects.GenericAPIRequest;
import org.bitandee.objects.GenericAPIResponse;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import commons.BitAndeeConstants;
import commons.BitAndeeUtils;

public class API_GetMarketSellLimit extends API_BitAndee implements Callable<GenericAPIResponse> {

	public API_GetMarketSellLimit(GenericAPIRequest apiRequest) {
		super(apiRequest);
	}

	@Override
	public GenericAPIResponse call() throws Exception {
		HttpResponse<JsonNode> response = Unirest
				.get(BitAndeeUtils.generateGetURL(BitAndeeConstants._GET_MARKET_SELL_LIMIT, getApiRequest().getParamMap()))
				.asJson();
		return new GenericAPIResponse(response.getBody());
	}
}
