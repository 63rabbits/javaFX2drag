package javaFX2drag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Drag extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(this.getClass().getResource("Drag.fxml"));
		Scene scene = new Scene(root);

		stage.setTitle("JavaFX 2 drag");

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
