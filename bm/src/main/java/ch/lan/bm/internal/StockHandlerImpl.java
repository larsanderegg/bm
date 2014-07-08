package ch.lan.bm.internal;

import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.Stock;

public class StockHandlerImpl implements StockHandler {

	@Override
	public void handleWon(final Bet bet, final Stock stock) {
		if (stock != null) {
			stock.increaseWonTimes();

			final double wonAmount = bet.getAmount() * bet.getOdds();
			System.out.println("You won "+wonAmount);
			stock.increaseCapital(wonAmount);
		}
	}

	@Override
	public void handleLost(final Bet bet, final Stock stock) {
		if (stock != null) {
			stock.increaseLostTimes();

//			stock.decreaseCapital(bet.getAmount());
		}

	}

}
