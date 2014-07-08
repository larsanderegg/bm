package ch.lan.bm.provider;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import ch.lan.bm.internal.data.Bet;

public class SimulatedBetProvider implements BetsProvider {

	private final int amountOfBets;
	private final Random random;


	/**
	 * Default Constructor
	 * @param amountOfBets the amount of bets
	 */
	public SimulatedBetProvider(final int amountOfBets) {
		this.amountOfBets = amountOfBets;
		this.random = new Random();
	}

	@Override
	public Collection<Bet> getBets(final double minOdds, final double maxOdds) {
		final Collection<Bet> result = new HashSet<>();

		for (int i = 0; i < amountOfBets; i++) {
			result.add(generateBet(minOdds, maxOdds));
		}

		return result;
	}

	private Bet generateBet(final double minOdds, final double maxOdds) {
		final Bet result = new Bet();

		final double range = (maxOdds - minOdds);
		double odds = (Math.random() * range) + minOdds;

		odds = Math.round( odds * 100. ) / 100.;

		result.setOdds(odds);

		return result;
	}

}
