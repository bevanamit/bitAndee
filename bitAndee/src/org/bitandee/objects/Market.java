package org.bitandee.objects;

public class Market {

	private String market;
	private double high;
	private double low;
	private double last;
	private double new_low;
	private double old_low;
	private boolean newLow;

	public Market(String market, double high, double low, double last) {
		this.market = market;
		this.high = high;
		this.low = low;
		this.last = last;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getLast() {
		return last;
	}

	public void setLast(double last) {
		this.last = last;
	}

	public void setNew_low(double new_low) {
		this.new_low = new_low;
		setNewLow(true);
	}

	public boolean isNewLow() {
		return newLow;
	}

	public void setNewLow(boolean newLow) {
		this.newLow = newLow;
	}

	public double getOld_low() {
		return old_low;
	}

	public void setOld_low(double old_low) {
		this.old_low = old_low;
	}

	public double getNew_low() {
		return new_low;
	}
}
