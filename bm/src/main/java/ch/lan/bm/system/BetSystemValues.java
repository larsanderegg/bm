package ch.lan.bm.system;

public class BetSystemValues {


	private int amountOfRounds;
	private int betsPerRound;

	private double startCapital;
	private double maxProfit;
	private double startAfterMaxProfit;
	private double savingBound;
	private double savingValue;

	private double minOdds;
	private double maxOdds;



	/**
	 * @param amountOfRounds the amountOfRounds to set
	 */
	public void setAmountOfRounds(final int amountOfRounds) {
		this.amountOfRounds = amountOfRounds;
	}



	/**
	 * @param betsPerRound the betsPerRound to set
	 */
	public void setBetsPerRound(final int betsPerRound) {
		this.betsPerRound = betsPerRound;
	}



	/**
	 * @param startCapital the startCapital to set
	 */
	public void setStartCapital(final double startCapital) {
		this.startCapital = startCapital;
	}



	/**
	 * @param maxProfit the maxProfit to set
	 */
	public void setMaxProfit(final double maxProfit) {
		this.maxProfit = maxProfit;
	}



	/**
	 * @param startAfterMaxProfit the startAfterMaxProfit to set
	 */
	public void setStartAfterMaxProfit(final double startAfterMaxProfit) {
		this.startAfterMaxProfit = startAfterMaxProfit;
	}



	/**
	 * @param savingBound the savingBound to set
	 */
	public void setSavingBound(final double savingBound) {
		this.savingBound = savingBound;
	}



	/**
	 * @param savingValue the savingValue to set
	 */
	public void setSavingValue(final double savingValue) {
		this.savingValue = savingValue;
	}



	/**
	 * @param minOdds the minOdds to set
	 */
	public void setMinOdds(final double minOdds) {
		this.minOdds = minOdds;
	}



	/**
	 * @param maxOdds the maxOdds to set
	 */
	public void setMaxOdds(final double maxOdds) {
		this.maxOdds = maxOdds;
	}



	/**
	 * @return the amountOfRounds
	 */
	public int getAmountOfRounds() {
		return amountOfRounds;
	}



	/**
	 * @return the betsPerRound
	 */
	public int getBetsPerRound() {
		return betsPerRound;
	}



	/**
	 * @return the startCapital
	 */
	public double getStartCapital() {
		return startCapital;
	}



	/**
	 * @return the maxProfit
	 */
	public double getMaxProfit() {
		return maxProfit;
	}



	/**
	 * @return the startAfterMaxProfit
	 */
	public double getStartAfterMaxProfit() {
		return startAfterMaxProfit;
	}



	/**
	 * @return the savingBound
	 */
	public double getSavingBound() {
		return savingBound;
	}



	/**
	 * @return the savingValue
	 */
	public double getSavingValue() {
		return savingValue;
	}



	/**
	 * Returns the minOdds
	 *
	 * @return the minOdds
	 */
	public double getMinOdds() {
		return minOdds;
	}

	/**
	 * Returns the maxOdds
	 *
	 * @return the maxOdds
	 */
	public double getMaxOdds() {
		return maxOdds;
	}
}
