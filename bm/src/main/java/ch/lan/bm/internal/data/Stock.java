package ch.lan.bm.internal.data;

public class Stock {

	private double capital;
	private double savings;

	private int wonTimes = 0;
	private int lostTimes = 0;

	public Stock(final double capital) {
		this.capital = capital;
	}

	public void increaseSavings(final double plus){
		savings += plus;
		capital -= plus;
	}

	public void increaseCapital(final double plus) {
		capital += plus;
	}

	public void decreaseCapital(final double minus) {
		capital -= minus;
	}

	public void increaseWonTimes() {
		wonTimes++;
	}

	public void increaseLostTimes() {
		lostTimes++;
	}

	/**
	 * Sets the capital
	 * @param capital the capital to set
	 */
	public void setCapital(final double capital) {
		this.capital = capital;
	}

	/**
	 * Returns the capital + saving
	 *
	 * @return the capital + saving
	 */
	public double getTotalCapital() {
		return capital+savings;
	}

	/**
	 * Return the capital
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

	/**
	 * Return the savings
	 * @return the savings
	 */
	public double getSavings() {
		return savings;
	}
}
