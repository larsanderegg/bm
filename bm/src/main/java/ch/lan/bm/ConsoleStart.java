package ch.lan.bm;

import ch.lan.bm.internal.BetEngine;
import ch.lan.bm.internal.StockHandler;
import ch.lan.bm.internal.StockHandlerImpl;
import ch.lan.bm.internal.data.BetEngineConfiguration;
import ch.lan.bm.placer.BetPlacer;
import ch.lan.bm.placer.SimulatedBetPlacer;
import ch.lan.bm.provider.BetsProvider;
import ch.lan.bm.provider.SimulatedBetProvider;
import ch.lan.bm.result.ResultListener;
import ch.lan.bm.result.SimulatedResultListener;
import ch.lan.bm.system.BetSystem;

public class ConsoleStart {

	/**
	 * 1. amountOfRounds 2. startCapital 3. minOdds 4. maxOdds
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length == 4) {
			BetPlacer betPlacer = new SimulatedBetPlacer();
			BetsProvider betsProvider = new SimulatedBetProvider();
			ResultListener resultListener = new SimulatedResultListener();
			StockHandler stockHandler = new StockHandlerImpl();

			BetEngineConfiguration configuration = new BetEngineConfiguration();
			configuration.setAmountOfRounds(Integer.parseInt(args[0]));
			configuration.setStartCapital(Double.parseDouble(args[1]));

			BetSystem betSystem = new BetSystem(Double.parseDouble(args[2]),
					Double.parseDouble(args[3]));

			BetEngine betEngine = new BetEngine(betPlacer, betsProvider,
					resultListener, betSystem, configuration, stockHandler, null);

			betEngine.start();

		} else {
			System.out
					.println("Please enter: amountOfRounds, startCapital, minOdds, maxOdds");
		}
	}

}
