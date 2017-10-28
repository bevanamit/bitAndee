package org.bitandee.analyzer.service;

import org.bitandee.objects.Market;
import org.bitandee.objects.MarketCache;
import org.bitandee.taskmanager.TrackHighLowLast5SecondsAlgorithm;
import org.bitandee.threads.ThrreadManager;

public class StrategyImpl implements Strategy {

	MarketCache instance = MarketCache.getInstance();

	@Override
	public void trackHighLowLast5SecondsAlgorithm(String market) {
		boolean buy = false;
		TrackHighLowLast5SecondsAlgorithm task = new TrackHighLowLast5SecondsAlgorithm(market);
		new ThrreadManager().runJob(task);
		Market marketData = instance.getMarket(market);
		while (true) {
			if (marketData.isNewLow()) {
				System.out.println(this.getClass() + "  New Low found");
				double curVal = marketData.getLast();
				double oldLow = marketData.getOld_low();
				while (curVal < oldLow) {
					curVal = marketData.getLast();
				}
				System.out.println(this.getClass() + " Buy Call Given");
				buy = true;
				break;
			}
		}
		if (buy) {
			task.setKeepRunning(false);
		}
	}
}
