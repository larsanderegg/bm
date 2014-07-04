package ch.lan.bm.internal.data;

public class BetEngineConfiguration {

	private double startCapital;

	private int amountOfRounds;
	private int interval;

	/**
	 * Returns the amountOfRounds
	 * 
	 * @return the amountOfRounds
	 */
	public int getAmountOfRounds() {
		return amountOfRounds;
	}

	/**
	 * Returns the interval
	 * 
	 * @return the interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * Returns the startCapital
	 * 
	 * @return the startCapital
	 */
	public double getStartCapital() {
		return startCapital;
	}

	/**
	 * Sets the startCapital
	 * 
	 * @param startCapital
	 *            the startCapital to set
	 */
	public void setStartCapital(double startCapital) {
		this.startCapital = startCapital;
	}

	/**
	 * Sets the amountOfRounds
	 * 
	 * @param amountOfRounds
	 *            the amountOfRounds to set
	 */
	public void setAmountOfRounds(int amountOfRounds) {
		this.amountOfRounds = amountOfRounds;
	}

	/**
	 * Sets the interval
	 * 
	 * @param interval
	 *            the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

}
