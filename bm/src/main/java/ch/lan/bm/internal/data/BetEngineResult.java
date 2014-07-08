package ch.lan.bm.internal.data;

import java.util.Map;
import java.util.TreeMap;

public class BetEngineResult {

	private final Map<String, Double> bets = new TreeMap<>();

	private Stock stock;

	/**
	 * Return the stock
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * Sets the stock
	 * @param stock the stock to set
	 */
	public void setStock(final Stock stock) {
		this.stock = stock;
	}

	/**
	 * Add a bet
	 * @param roundId the roundId
	 * @param amount the amount
	 */
	public void addBet(final String roundId, final Double amount) {
		bets.put(roundId, amount);
	}

	/**
	 * Return the bets
	 * @return the bets
	 */
	public Map<String, Double> getBets() {
		return bets;
	}
}
