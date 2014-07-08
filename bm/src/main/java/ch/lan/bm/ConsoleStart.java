package ch.lan.bm;

import ch.lan.bm.internal.BetEngine;
import ch.lan.bm.internal.StockHandler;
import ch.lan.bm.internal.StockHandlerImpl;
import ch.lan.bm.placer.BetPlacer;
import ch.lan.bm.placer.SimulatedBetPlacer;
import ch.lan.bm.provider.BetsProvider;
import ch.lan.bm.provider.SimulatedBetProvider;
import ch.lan.bm.result.ResultListener;
import ch.lan.bm.result.SimulatedResultListener;
import ch.lan.bm.system.BetSystem;
import ch.lan.bm.system.BetSystemImpl;
import ch.lan.bm.system.BetSystemValues;

public class ConsoleStart {

	/**
	 * 1. amountOfRounds 2. startCapital 3. minOdds 4. maxOdds 5.winningChance
	 *
	 * @param args
	 */
	public static void main(final String[] args) {

		if (args.length == 5) {
			final BetSystemValues betSystemValues = new BetSystemValues();
			betSystemValues.setAmountOfRounds(Integer.parseInt(args[0]));
			betSystemValues.setBetsPerRound(10);
			betSystemValues.setStartCapital(Double.parseDouble(args[1]));
			betSystemValues.setMaxProfit(0);
			betSystemValues.setStartAfterMaxProfit(0);
			betSystemValues.setSavingBound(0);
			betSystemValues.setSavingValue(0);
			betSystemValues.setMinOdds(Double.parseDouble(args[2]));
			betSystemValues.setMaxOdds(Double.parseDouble(args[3]));
			final BetSystem betSystem = new BetSystemImpl(betSystemValues);

			final StockHandler stockHandler = new StockHandlerImpl();

	        final BetPlacer betPlacer = new SimulatedBetPlacer();
			final BetsProvider betsProvider = new SimulatedBetProvider(betSystemValues.getBetsPerRound());
			final ResultListener resultListener = new SimulatedResultListener(Double.parseDouble(args[4]));

			final BetEngine betEngine = new BetEngine(betPlacer, betsProvider,
					resultListener, betSystem, stockHandler);

			betEngine.start();

		} else {
			System.out
					.println("Please enter: amountOfRounds, startCapital, minOdds, maxOdds, winningChance");
		}
	}

}
