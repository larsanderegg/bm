package ch.lan.bm.internal;

import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.Stock;

public class StockHandlerImpl implements StockHandler {

	@Override
	public void handleWon(Bet bet, Stock stock) {
		if (stock != null) {
			stock.increaseWonTimes();

			double wonAmount = bet.getAmount() * bet.getOdds();
			stock.increaseCapital(wonAmount);
		}
	}

	@Override
	public void handleLost(Bet bet, Stock stock) {
		if (stock != null) {
			stock.increaseLostTimes();

			stock.decreaseCapital(bet.getAmount());
		}

	}

}
