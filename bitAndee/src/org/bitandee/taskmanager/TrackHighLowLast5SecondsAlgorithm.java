package org.bitandee.taskmanager;

import org.bitandee.objects.Market;
import org.bitandee.objects.MarketCache;

public class TrackHighLowLast5SecondsAlgorithm implements Runnable {

	private boolean keepRunning = true;

	private String market;
	private MarketCache instance = MarketCache.getInstance();

	public TrackHighLowLast5SecondsAlgorithm(String market) {
		this.market = market;
	}

	@Override
	public void run() {
		while (keepRunning) {
			Market marketData = instance.getMarket(market);
			double low = marketData.getLow();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			double curVal = marketData.getLast();
			double difference = curVal - low;
			System.out.println("Values : Low = " + marketData.getLow() + " , High = " + marketData.getHigh()
					+ " , Cur = " + marketData.getLast());
			if (difference < 0) {
				System.out.println(this.getClass() + "  New Low found - Seeting New Low");
				marketData.setNew_low(curVal);
			}
		}
		System.out.println(this.getClass() + "  Thread is Ending.");
	}

	public boolean isKeepRunning() {
		return keepRunning;
	}

	public void setKeepRunning(boolean keepRunning) {
		this.keepRunning = keepRunning;
	}
}
