package ch.lan.bm.result;

import java.util.Collection;

import ch.lan.bm.internal.StockHandler;
import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.Stock;

public class SimulatedResultListener implements ResultListener {

	private final double winnigChance;

	public SimulatedResultListener(final double winnigChance) {
		this.winnigChance = winnigChance/100;
	}

	@Override
	public void listenForBets(final Collection<Bet> bets, final StockHandler stockHandler,
			final Stock stock) {
		for (final Bet bet : bets) {
			final boolean won = Math.random() < winnigChance;
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
