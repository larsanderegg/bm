package ch.lan.bm.internal.data;

public class Stock {

	private double capital;
	private int wonTimes = 0;
	private int lostTimes = 0;

	public Stock(double capital) {
		this.capital = capital;
	}

	public void increaseCapital(double plus) {
		capital += plus;
	}

	public void decreaseCapital(double minus) {
		capital -= minus;
	}

	public void increaseWonTimes() {
		wonTimes++;
	}

	public void increaseLostTimes() {
		lostTimes++;
	}

	/**
	 * Returns the capital
	 * 
	 * @return the capital
	 */
	public double getCapital() {
		return capital;
	}

	/**
	 * Returns the wonTimes
	 * 
	 * @return the wonTimes
	 */
	public int getWonTimes() {
		return wonTimes;
	}

	/**
	 * Returns the lostTimes
	 * 
	 * @return the lostTimes
	 */
	public int getLostTimes() {
		return lostTimes;
	}
}
