package ch.lan.bm.internal.data;

/**
 * Container for one bet
 *
 * @author Lars
 *
 */
public class Bet {

	private double amount;
	private double odds;

	/**
	 * Returns the amount
	 *
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount
	 *
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(final double amount) {
		this.amount = amount;
	}

	/**
	 * Returns the odds
	 *
	 * @return the odds
	 */
	public double getOdds() {
		return odds;
	}

	/**
	 * Sets the odds
	 *
	 * @param odds
	 *            the odds to set
	 */
	public void setOdds(final double odds) {
		this.odds = odds;
	}

	@Override
	public String toString() {
		return "Bet[amount="+amount+", odds="+odds+"]";
	}
}
