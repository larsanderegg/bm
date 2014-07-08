package ch.lan.bm.system;

import java.util.Collection;

import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.Stock;

public interface BetSystem {

	/**
	 * Depending on the system fill and filters the given bets
	 * @param bets the bets to use
	 * @param stock the stock to use
	 *
	 * @return a collection of bets, may be empty
	 */
	Collection<Bet> calculateBets(final Collection<Bet> bets, final Stock stock);


	/**
	 * @return the bet system values
	 */
	BetSystemValues getSystemValues();
}
