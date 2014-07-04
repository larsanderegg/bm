package ch.lan.bm.provider;

import java.util.Collection;

import ch.lan.bm.internal.data.Bet;

/**
 * Provides available Bets
 * 
 * @author Lars
 * 
 */
public interface BetsProvider {

	/**
	 * Returns the bets which are between min odds and max odds.
	 * 
	 * @param minOdds
	 *            the min odds
	 * @param maxOdds
	 *            the max odds
	 * @return a collection of bets, empty when no bets found
	 */
	Collection<Bet> getBets(double minOdds, double maxOdds);

}
