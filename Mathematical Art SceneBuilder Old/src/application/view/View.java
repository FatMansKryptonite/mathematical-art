package application.view;

import java.io.IOException;

import application.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class View {

	private Model m;
	private Scene scene;
	
	public View(Model m) throws IOException {
		this.m = m;
		setup();
	}
	
	private void setup() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(View.class.getResource("View.fxml"));
		BorderPane mainLayout = loader.load();
		scene = new Scene(mainLayout);
	}

	public Scene getScene() {
		return scene;
	}

//private void showMainItems() throws IOException {
//	FXMLLoader loader = new FXMLLoader();
//	loader.setLocation(Main.class.getResource("view/MandelbrotView.fxml"));
//	mainItems = loader.load();
//	mainLayout.setCenter(mainItems);
//}

}
