package ch.lan.bm.internal;

import java.util.Collection;

import ch.lan.bm.internal.data.Bet;
import ch.lan.bm.internal.data.BetEngineConfiguration;
import ch.lan.bm.internal.data.Stock;
import ch.lan.bm.placer.BetPlacer;
import ch.lan.bm.provider.BetsProvider;
import ch.lan.bm.result.ResultListener;
import ch.lan.bm.system.BetSystem;

/**
 * Process the bets
 * 
 * @author Lars
 * 
 */
public class BetEngine {

	private final Stock stock;

	private final BetsProvider betsProvider;
	private final BetPlacer betPlacer;
	private final ResultListener resultListener;
	private final BetEngineConfiguration configuration;
	private final BetSystem betSystem;
	private final StockHandler stockHandler;

	/**
	 * Default Constructor
	 * 
	 * @param betPlacer
	 *            the bet placer to use
	 * @param betsProvider
	 *            the bets provider to use
	 * @param resultListener
	 *            the result listener to use
	 * @param configuration
	 *            the configuration to use
	 * @param stockHandler
	 *            the stockHandler to use
	 */
	public BetEngine(final BetPlacer betPlacer,
			final BetsProvider betsProvider,
			final ResultListener resultListener, final BetSystem betSystem,
			final BetEngineConfiguration configuration,
			final StockHandler stockHandler) {
		this.betPlacer = betPlacer;
		this.betsProvider = betsProvider;
		this.resultListener = resultListener;
		this.configuration = configuration;
		this.betSystem = betSystem;
		this.stockHandler = stockHandler;

		stock = new Stock(configuration.getStartCapital());
	}

	/**
	 * Starts the process
	 */
	public void start() {
		process();
	}

	private void process() {

		for (int i = 0; i < configuration.getAmountOfRounds(); i++) {

			System.out
					.println("You're start capital is: " + stock.getCapital());
			Collection<Bet> bets = betsProvider.getBets(betSystem.getMinOdds(),
					betSystem.getMaxOdds());

			bets = betSystem.calcBets(bets, stock);

			betPlacer.place(bets);

			resultListener.listenForBets(bets, stockHandler, stock);

			if (stock.getCapital() <= 1) {
				System.out.println("You're broke after " + i + " rounds");
				break;
			}

			System.out.println("You're end captial is: " + stock.getCapital()
					+ ".");
			System.out.println("You've won " + stock.getWonTimes() + " times.");
			System.out.println("You've lost " + stock.getLostTimes()
					+ " times.");
			System.out.println("--------------------------" + i
					+ "-----------------------------");
		}

	}

}
