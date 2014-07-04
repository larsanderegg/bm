package ch.lan.bm.system;

import java.util.Collection;

import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.Stock;

/**
 * @author Lars
 * 
 */
public class BetSystem {

	private final double minOdds;
	private final double maxOdds;

	/**
	 * @param minOdds
	 * @param maxOdds
	 */
	public BetSystem(double minOdds, double maxOdds) {
		this.minOdds = minOdds;
		this.maxOdds = maxOdds;
	}

	public Collection<Bet> calcBets(Collection<Bet> bets, Stock stock) {
		double betAmount = stock.getCapital() / bets.size();
		System.out.println("Set betAmount to: " + betAmount);
		for (Bet bet : bets) {
			bet.setAmount(betAmount);
		}

		return bets;
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
