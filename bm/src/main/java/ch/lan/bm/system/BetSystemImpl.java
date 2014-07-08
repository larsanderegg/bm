package ch.lan.bm.system;

import java.util.Collection;

import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.Stock;

/**
 * Implements the bet system explained by adu
 *
 * @author Lars
 *
 */
public class BetSystemImpl  implements BetSystem {

	private final BetSystemValues systemValues;

	/**
	 * @param systemValues the system values to use
	 */
	public BetSystemImpl(final BetSystemValues systemValues) {
		this.systemValues = systemValues;
	}


	@Override
	public Collection<Bet> calculateBets(final Collection<Bet> bets, final Stock stock) {
		final double betAmount = stock.getCapital() / systemValues.getBetsPerRound();
		System.out.println("Set betAmount to: " + betAmount);

		int i = 0;
		for (final Bet bet : bets) {
			bet.setAmount(betAmount);
			stock.decreaseCapital(betAmount);
			i++;
			if(i == systemValues.getBetsPerRound()){
				break;
			}
		}

		return bets;
	}


	@Override
	public BetSystemValues getSystemValues() {
		return systemValues;
	}
}
