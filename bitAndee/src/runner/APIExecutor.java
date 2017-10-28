package runner;

import java.util.concurrent.Future;

import org.bitandee.objects.GenericAPIRequest;
import org.bitandee.objects.GenericAPIResponse;
import org.bitandee.taskmanager.API_GetMarketBuyLimit;
import org.bitandee.taskmanager.API_GetMarketCancel;
import org.bitandee.taskmanager.API_GetMarketSellLimit;
import org.bitandee.taskmanager.API_GetMarketSummaries;
import org.bitandee.taskmanager.API_GetMarketSummary;
import org.bitandee.threads.ThrreadManager;

import commons.BitAndeeConstants;

public class APIExecutor {

	private ThrreadManager threadManager = new ThrreadManager();

	public Future<GenericAPIResponse> execGetSummaries() {
		API_GetMarketSummaries apiGetMarketSummaries = new API_GetMarketSummaries();
		return threadManager.runJob(apiGetMarketSummaries);
	}

	public Future<GenericAPIResponse> execGetSummary() {
		GenericAPIRequest apiRequest = new GenericAPIRequest();
		apiRequest.addParam(BitAndeeConstants._PARAM_MARKET, BitAndeeConstants._PARAM_CUR_COIN);
		API_GetMarketSummary apiGetMarketSummary = new API_GetMarketSummary(apiRequest);
		return threadManager.runJob(apiGetMarketSummary);
	}

	public Future<GenericAPIResponse> execBuyLimit() {
		GenericAPIRequest apiRequest = new GenericAPIRequest();
		apiRequest.addParam(BitAndeeConstants._PARAM_API_KEY, "input1");
		apiRequest.addParam(BitAndeeConstants._PARAM_MARKET, "input1");
		apiRequest.addParam(BitAndeeConstants._PARAM_QTY, "input3");
		apiRequest.addParam(BitAndeeConstants._PARAM_RATE, "input4");
		API_GetMarketBuyLimit apiGetMarkeyBuyLimit = new API_GetMarketBuyLimit(apiRequest);
		return threadManager.runJob(apiGetMarkeyBuyLimit);
	}

	public Future<GenericAPIResponse> execSellLimit() {
		GenericAPIRequest apiRequest = new GenericAPIRequest();
		apiRequest.addParam(BitAndeeConstants._PARAM_API_KEY, "input1");
		apiRequest.addParam(BitAndeeConstants._PARAM_MARKET, "input1");
		apiRequest.addParam(BitAndeeConstants._PARAM_QTY, "input3");
		apiRequest.addParam(BitAndeeConstants._PARAM_RATE, "input4");
		API_GetMarketSellLimit apiGetMarkeySellLimit = new API_GetMarketSellLimit(apiRequest);
		return threadManager.runJob(apiGetMarkeySellLimit);
	}
	
	public Future<GenericAPIResponse> execCancel() {
		GenericAPIRequest apiRequest = new GenericAPIRequest();
		apiRequest.addParam(BitAndeeConstants._PARAM_API_KEY, "input1");
		apiRequest.addParam(BitAndeeConstants._PARAM_UUID, "input2");
		API_GetMarketCancel apiGetMarkeySellLimit = new API_GetMarketCancel(apiRequest);
		return threadManager.runJob(apiGetMarkeySellLimit);
	}

}
