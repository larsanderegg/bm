package ch.lan.bm.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;

/**
 *
 * @author Lars
 */
public class MainController implements Initializable {
	
	@FXML
	private BarChart<String, Double> barChart;

	@FXML
    private CategoryAxis xAxis;

    private ObservableList<String> xLabels = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
       for (int i = 0; i < 10; i++) {
    	   xLabels.add("Round "+i);
       }
        xAxis.setCategories(xLabels);
    }
    
    public void setValues(){
    	double[] values = new double[10];
    	for (int i = 0; i < 10; i++) {
    		values[i] = i;
    	}
    	
    	XYChart.Series<String, Double> series = new XYChart.Series<>();
    	
    	int i = 0;
    	for (double d : values) {
    		series.getData().add(new Data<String, Double>("Round "+i,d));
    		i++;
		}
    	
    	barChart.getData().add(series);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
