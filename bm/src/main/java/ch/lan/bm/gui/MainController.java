package ch.lan.bm.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.TextField;
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
	private BarChart<String, Double> barChart;

	@FXML
    private CategoryAxis xAxis;

    private ObservableList<String> xLabels = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
       for (int i = 0; i < 200; i++) {
    	   xLabels.add("Round "+i);
       }
        xAxis.setCategories(xLabels);
    }
    
    public void startBetEngine(ActionEvent event) {
        BetPlacer betPlacer = new SimulatedBetPlacer();
		BetsProvider betsProvider = new SimulatedBetProvider();
		ResultListener resultListener = new SimulatedResultListener();
		StockHandler stockHandler = new StockHandlerImpl();

		BetEngineConfiguration configuration = new BetEngineConfiguration();
		configuration.setAmountOfRounds(Integer.parseInt(amountOfRounds.getText()));
		configuration.setStartCapital(Double.parseDouble(startCapital.getText()));

		BetSystem betSystem = new BetSystem(Double.parseDouble(minOdds.getText()),
				Double.parseDouble(maxOdds.getText()));

		BetEngine betEngine = new BetEngine(betPlacer, betsProvider,
				resultListener, betSystem, configuration, stockHandler, barChart);

		betEngine.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
