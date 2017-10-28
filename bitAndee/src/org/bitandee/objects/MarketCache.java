package org.bitandee.objects;

import java.util.HashMap;
import java.util.Map;

public class MarketCache {

	private static MarketCache INSTANCE;

	Map<String, Market> marketCache = new HashMap<String, Market>();

	public Map<String, Market> getMarketCache() {
		return marketCache;
	}

	public void addMarket(Market market) {
		getMarketCache().put(market.getMarket(), market);
	}

	public Market getMarket(String market) {
		return getMarketCache().get(market);
	}

	public static MarketCache getInstance() {
		if (INSTANCE == null) {
			synchronized (MarketCache.class) {
				if (INSTANCE == null) {
					INSTANCE = new MarketCache();
				}
			}
		}
		return INSTANCE;
	}
}
