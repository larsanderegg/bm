package ch.lan.bm.gui;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.TextField;
import ch.lan.bm.internal.BetEngine;
import ch.lan.bm.internal.StockHandler;
import ch.lan.bm.internal.StockHandlerImpl;
import ch.lan.bm.internal.data.BetEngineResult;
import ch.lan.bm.placer.BetPlacer;
import ch.lan.bm.placer.SimulatedBetPlacer;
import ch.lan.bm.provider.BetsProvider;
import ch.lan.bm.provider.SimulatedBetProvider;
import ch.lan.bm.result.ResultListener;
import ch.lan.bm.result.SimulatedResultListener;
import ch.lan.bm.system.BetSystem;
import ch.lan.bm.system.BetSystemImpl;
import ch.lan.bm.system.BetSystemValues;

/**
 *
 * @author Lars
 */
public class MainController implements Initializable {

	@FXML
	private TextField amountOfRounds;

	@FXML
	private TextField startCapital;

	@FXML
	private TextField minOdds;

	@FXML
	private TextField maxOdds;

	@FXML
	private TextField betsPerRound;

	@FXML
	private TextField maxProfit;

	@FXML
	private TextField captitalAfterMax;

	@FXML
	private TextField savingBound;

	@FXML
	private TextField savingPercent;

	@FXML
	private TextField winningChance;

	@FXML
	private BarChart<String, Double> capitalChart;

	@FXML
	private BarChart<String, Double> winLostChart;

	@FXML
    private CategoryAxis xAxis;

    private final ObservableList<String> xLabels = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

    	for (int i = 0; i < 200; i++) {
	    	   xLabels.add("Round "+i);
	    }
	    xAxis.setCategories(xLabels);
    }

    public void startBetEngine(final ActionEvent event) {
    	final StockHandler stockHandler = new StockHandlerImpl();

    	final int amountOfRoundsInt = (int)parseNumber(amountOfRounds.getText());
    	final int betsPerRoundInt = (int)parseNumber(betsPerRound.getText());
    	final double startCapitalDouble = parseNumber(startCapital.getText());
    	final double maxProfitDouble = parseNumber(maxProfit.getText());
    	final double captitalAfterMaxDouble = parseNumber(captitalAfterMax.getText());
    	final double savingBoundDouble = parseNumber(savingBound.getText());
    	final double savingPercentDouble = parseNumber(savingPercent.getText());
    	final double minOddsDouble = parseNumber(minOdds.getText());
    	final double maxOddsDouble = parseNumber(maxOdds.getText());

    	final BetSystemValues betSystemValues = new BetSystemValues();
		betSystemValues.setAmountOfRounds(amountOfRoundsInt);
		betSystemValues.setBetsPerRound(betsPerRoundInt);
		betSystemValues.setStartCapital(startCapitalDouble);
		betSystemValues.setMaxProfit(maxProfitDouble);
		betSystemValues.setStartAfterMaxProfit(captitalAfterMaxDouble);
		betSystemValues.setSavingBound(savingBoundDouble);
		betSystemValues.setSavingValue(savingPercentDouble);
		betSystemValues.setMinOdds(minOddsDouble);
		betSystemValues.setMaxOdds(maxOddsDouble);
		final BetSystem betSystem = new BetSystemImpl(betSystemValues);

        final BetPlacer betPlacer = new SimulatedBetPlacer();
		final BetsProvider betsProvider = new SimulatedBetProvider(betSystemValues.getBetsPerRound());
		final ResultListener resultListener = new SimulatedResultListener(Double.parseDouble(winningChance.getText()));

		final BetEngine betEngine = new BetEngine(betPlacer, betsProvider,
				resultListener, betSystem, stockHandler);

		final BetEngineResult result = betEngine.start();

		final XYChart.Series<String, Double> series = new XYChart.Series<>();

		for (final Entry<String, Double> entry : result.getBets().entrySet()) {
			series.getData().add(new Data<String, Double>(entry.getKey(), entry.getValue()));
		}

		final DecimalFormat df = new DecimalFormat("###.##");

		series.nameProperty().setValue(df.format(result.getStock().getTotalCapital()));
		capitalChart.getData().add(series);
    }

    private double parseNumber(final String input){
    	double result = 0;
    	try{
    		result = Double.parseDouble(input);
    	} catch(final NumberFormatException e){}
		return result;
    }

    public void clearChart(final ActionEvent event){
    	capitalChart.getData().clear();
    	winLostChart.getData().clear();
    }

    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
    }
}
