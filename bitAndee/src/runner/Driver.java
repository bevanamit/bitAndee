package runner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.bitandee.analyzer.service.StrategyImpl;
import org.bitandee.objects.GenericAPIResponse;
import org.bitandee.objects.Market;
import org.bitandee.objects.MarketCache;
import org.bitandee.threads.ThrreadManager;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import commons.BitAndeeConstants;

public class Driver {

	private static APIExecutor executor = new APIExecutor();

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Market m = createMarket(resolveData());
		MarketCache.getInstance().addMarket(m);
		new ThrreadManager().runJob(new Runnable() {

			@Override
			public void run() {
				new StrategyImpl().trackHighLowLast5SecondsAlgorithm(BitAndeeConstants._PARAM_CUR_COIN);

			}
		});
		while (true) {
			getMarket(m);
		}
	}
	
	public static JsonNode resolveData() throws InterruptedException, ExecutionException {
		Future<GenericAPIResponse> response = testAPI(BitAndeeConstants._GET_MARKET_SUMMARY);
		while (response.isDone()) {

		}
		return response.get().getJsonNode();
	}

	public static void getMarket(Market m) throws InterruptedException, ExecutionException {
		Thread.sleep(1000);
		JSONObject jObj = getMarketAsJSon(resolveData());
		double low = jObj.getDouble("Low");
		double last = jObj.getDouble("Last");
		m.setLow(low);
		m.setLast(last);

	}

	public static JSONObject getMarketAsJSon(JsonNode jsonNode) {
		JSONObject jObj = jsonNode.getObject();
		if ((Boolean) jObj.get("success")) {
			JSONArray jArr = (JSONArray) jObj.get("result");
			jObj = jArr.getJSONObject(0);
			return jObj;
		}
		return null;
	}

	public static Market createMarket(JsonNode jsonNode) {
		JSONObject jObj = getMarketAsJSon(jsonNode);
		String market = jObj.getString("MarketName");
		double high = jObj.getDouble("High");
		double low = jObj.getDouble("Low");
		double last = jObj.getDouble("Last");
		System.out.println(Driver.class.getName() + " Market first time " + " high = " + high + " low = " + low
				+ " last = " + last);
		Market m = new Market(market, high, low, last);
		return m;
	}

	public static Future<GenericAPIResponse> testAPI(String apiName) {
		Future<GenericAPIResponse> response = null;
		if (apiName.equals(BitAndeeConstants._GET_MARKET_SUMMARIES)) {
			response = executor.execGetSummaries();
		} else if (apiName.equals(BitAndeeConstants._GET_MARKET_SUMMARY)) {
			response = executor.execGetSummary();
		} else if (apiName.equals(BitAndeeConstants._GET_MARKET_BUY_LIMIT)) {
			response = executor.execBuyLimit();
		} else if (apiName.equals(BitAndeeConstants._GET_MARKET_SELL_LIMIT)) {
			response = executor.execSellLimit();
		}
		return response;
	}
}
