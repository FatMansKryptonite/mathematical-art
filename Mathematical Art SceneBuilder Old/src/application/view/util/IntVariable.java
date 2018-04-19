package application.view.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

public class IntVariable implements Publisher {
	
	//Variables
	private String tip;
	private boolean logarithmicSlider;
	private boolean setting = false;
	
	//Structural Elements
	private HBox box = new HBox();
	private Label title;
	private Slider slider;
	private IntField field;
	private Tooltip tooltip = new Tooltip();
	
	public IntVariable(int defaultValue, String title, String ghostDescription, 
			String tip, int[] range, boolean includeSlider, boolean logarithmicSlider) {
		this.tip = tip + "\n[" + range[0] + ", " + range[1] + "]";
		this.logarithmicSlider = logarithmicSlider;
		
		this.title = new Label(title);
		box.getChildren().add(this.title);
		if(includeSlider) {
			slider = new Slider(); 
			if(!logarithmicSlider) {
				slider.setMin(range[0]);
				slider.setMax(range[1]);
				slider.setValue(defaultValue);
			} else {
				slider.setMin(Math.log10(range[0]));
				slider.setMax(Math.log10(range[1]));
				slider.setValue(Math.log10(defaultValue));
			}
			
			slider.valueProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
					if(!setting) {
						if(!logarithmicSlider) {
							field.setInt(newValue.intValue());
						} else {
							field.setInt((int) Math.round(Math.pow(10, newValue.doubleValue())));
						}
						updateSubscribers();						
					}
				}
			});
			box.getChildren().add(this.slider);
		}
		
		field = new IntField(ghostDescription, defaultValue, this.tip);
		field.setRange(range[0], range[1]);
		field.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				if(!setting) {
					if(!newValue.equals("")) {
						if(!logarithmicSlider) {
							slider.setValue(Double.parseDouble(newValue));	
						} else {
							slider.setValue(Math.log10(Double.parseDouble(newValue)));
						}	
					}
					updateSubscribers();
				}
			}
		});
		
		box.getChildren().add(field);
		
		tooltip.setText(this.tip);
		Tooltip.install(box, tooltip);
	}
	
	public Node draw() {
		return box;
	}
	
	public int getInt() {
		return field.getInt();
	}
	
	public void setInt(int val) {
		setting = true;
		field.setInt(val);
		
		if(!logarithmicSlider) {
			slider.setValue(val);
		} else {
			slider.setValue(Math.log10(val));
		}
		setting = false;
	}
	
}
