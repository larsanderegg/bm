package ch.lan.bm.placer;

import java.util.Collection;

import ch.lan.bm.internal.data.Bet;

/**
 * Places the bet(s)
 * 
 * @author Lars
 * 
 */
public interface BetPlacer {

	/**
	 * Places the given bet(s)
	 * 
	 * @param bets
	 *            the bets to place
	 */
	void place(Collection<Bet> bets);

}
