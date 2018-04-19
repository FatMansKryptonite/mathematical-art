package application.view.util;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class MyLabeledTextField extends HBox {

	private Label descriptionLabel;
	public MyTextField textField;
	
	public MyLabeledTextField(String description, MyTextField textField) {
		
		descriptionLabel = new Label(description);
		this.textField = textField;
		
		this.getChildren().addAll(descriptionLabel, this.textField);
	}
	
	public MyLabeledTextField(String description, String promptText, String defaultText, String tip) {
		this(description, new MyTextField(promptText, defaultText, tip));
	}
	
	public String getText() {
		return textField.getText();
	}
}
