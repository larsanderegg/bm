package ch.lan.bm.result;

import java.util.Collection;

import ch.lan.bm.internal.StockHandler;
import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.Stock;

public class SimulatedResultListener implements ResultListener {

	@Override
	public void listenForBets(Collection<Bet> bets, StockHandler stockHandler,
			Stock stock) {
		System.out.println("Listen for " + bets.size() + " bets.");
		for (Bet bet : bets) {
			final boolean won = Math.random() < 0.4;
			if (won) {
				// System.out.println("won");
				stockHandler.handleWon(bet, stock);
			} else {
				// System.out.println("lost");
				stockHandler.handleLost(bet, stock);
			}
		}

	}

}
