package ch.lan.bm.provider;

import java.util.Collection;
import java.util.HashSet;

import ch.lan.bm.internal.data.Bet;

public class SimulatedBetProvider implements BetsProvider {

	private final static int amountOfBets = 10;

	@Override
	public Collection<Bet> getBets(double minOdds, double maxOdds) {
		Collection<Bet> result = new HashSet<>();

		for (int i = 0; i < amountOfBets; i++) {
			result.add(generateBet(minOdds, maxOdds));
		}

		return result;
	}

	private Bet generateBet(double minOdds, double maxOdds) {
		Bet result = new Bet();

		int min = (int) minOdds * 10;
		int max = (int) maxOdds * 10;

		double odds = (Math.random() * max + min) / 10;

		result.setOdds(odds);

		return result;
	}

}
