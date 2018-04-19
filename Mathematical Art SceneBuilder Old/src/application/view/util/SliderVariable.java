package application.view.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class SliderVariable implements Publisher {
	
	//Variables
	private boolean intSlider;
	private boolean logarithmicSlider;
	private boolean setting = false;
	 
	//Structural Elements
	@FXML
	private Slider slider;
	@FXML
	private TextField field;
	@FXML
	private Tooltip tip;
	
	public void setup(boolean intSlider, double defaultValue, double[] range, boolean logarithmicSlider) {
		this.intSlider = intSlider;
		this.logarithmicSlider = logarithmicSlider;
		
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
//				if(!setting) {
//					if(!logarithmicSlider) {
//						field.setDouble(newValue.doubleValue());
//					} else {
//						field.setDouble(Math.pow(10, newValue.doubleValue()));
//					}
//					updateSubscribers();	
//				}
				System.out.println("Hello");
			}
		});
		
//		field = new DoubleField(ghostDescription, defaultValue, this.tip);
//		field.setRange(range[0], range[1]);
//		field.textProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
//				if(!setting) {
//					if(!newValue.equals("")) {
//						if(!logarithmicSlider) {
//							slider.setValue(Double.parseDouble(newValue));	
//						} else {
//							slider.setValue(Math.log10(Double.parseDouble(newValue)));
//						}	
//					}
//					updateSubscribers();					
//				}
//			}
//		});
	}
	
//	public double getDouble() {
//		return field.getDouble();
//	}
//	
//	public void setDouble(double val) {
//		setting = true;
//		field.setDouble(val);
//		
//		if(!logarithmicSlider) {
//			slider.setValue(val);
//		} else {
//			slider.setValue(Math.log10(val));
//		}
//		setting = false;
//	}
	
}
