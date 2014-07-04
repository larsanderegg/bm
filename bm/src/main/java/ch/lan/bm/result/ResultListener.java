package ch.lan.bm.result;

import java.util.Collection;

import ch.lan.bm.internal.StockHandler;
import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.Stock;

/**
 * Listens for events and propagates them
 * 
 * @author Lars
 * 
 */
public interface ResultListener {

	/**
	 * Starts to listen for the given bets.
	 * 
	 * @param bets
	 *            the bets to listen on
	 * @param stockHandler
	 *            the handler which take care of the results
	 * @param stock
	 *            the stock to use
	 */
	void listenForBets(Collection<Bet> bets, StockHandler stockHandler,
			Stock stock);

}
