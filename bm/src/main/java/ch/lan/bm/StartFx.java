package ch.lan.bm;

import ch.lan.bm.gui.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lars
 */
public class StartFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/Main.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setTitle("BM");
		stage.setScene(scene);

		MainController mainController = loader.getController();
		mainController.setValues();

		stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
