package application;

import java.io.IOException;

import application.controller.Controller;
import application.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Model m = new Model();
		View v = new View(m);
		@SuppressWarnings("unused")
		Controller c = new Controller(m, v);
//		m.getAbstractView().update();
		
	    primaryStage.setTitle("Mathematical Art");
	    primaryStage.setScene(v.getScene());
	    primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
