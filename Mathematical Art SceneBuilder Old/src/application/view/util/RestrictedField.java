package application.view.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public abstract class RestrictedField<T> extends MyTextField {
		
	protected T[] range;
	
    public RestrictedField(String promptText, String defaultText, String tip) {
    	super(promptText, defaultText, tip);
    	setup();
    }
    
    public RestrictedField(String promptText, String defaultText) {
    	super(promptText, defaultText);
    	setup();
    }
    
    private void setup() {
        addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!isValid(getText())) {
                    event.consume();
                }
            }
        });

        textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue,
                                      String oldValue, String newValue) {
                if(!isValid(newValue)) {
                    setText(oldValue);
                }
            }
        });
    }

    abstract boolean isValid(final String value);
    
    abstract boolean inRange(T value);
    
    public abstract void setRange(T start, T stop);
}
