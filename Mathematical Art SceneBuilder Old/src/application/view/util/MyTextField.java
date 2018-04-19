package application.view.util;

import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class MyTextField extends TextField {
	
	public final static int PREF_WIDTH = 120;
	public final static int MAX_WIDTH = 200;
	
	final Tooltip tooltip = new Tooltip();
	String description = null;
	
	public MyTextField(String promptText, String defaultText) {
		super.setPromptText(promptText);
		super.setText(defaultText);
		
        this.setPrefWidth(PREF_WIDTH);
        this.setMaxWidth(MAX_WIDTH);
	}
	
	public MyTextField(String promptText, String defaultText, String tip) {
		this(promptText, defaultText);
		tooltip.setText(tip);
		this.setTooltip(tooltip);
	}
}
