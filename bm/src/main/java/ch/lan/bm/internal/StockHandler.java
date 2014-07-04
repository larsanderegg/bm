package ch.lan.bm.internal;

import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.Stock;

/**
 * Handles the stock
 * 
 * @author Lars
 * 
 */
public interface StockHandler {

	/**
	 * Handles a wining event
	 * 
	 * @param bet
	 *            the won bet
	 * @param stock
	 *            the stock to use
	 */
	void handleWon(Bet bet, Stock stock);

	/**
	 * Handles a losing event
	 * 
	 * @param bet
	 *            the lost bet
	 * @param stock
	 *            the stock to use
	 */
	void handleLost(Bet bet, Stock stock);

}
