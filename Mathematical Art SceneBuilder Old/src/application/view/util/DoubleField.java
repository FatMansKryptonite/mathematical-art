package application.view.util;

public class DoubleField extends RestrictedField<Double> {

	public boolean positive = false;
	
    public DoubleField(String promptText, double defaultText, String tip) {
        super(promptText, Double.toString(defaultText), tip);
    }

    boolean isValid(final String value) {
        if (value.length() == 0 || value.equals(".") || (value.equals("-") && !positive)) {
            return true;
        }

        if (value.length() - value.replace(".", "").length() > 1) {
            return false;
        }

        try {
            Double val = Double.parseDouble(value);
            return inRange(val);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getDouble() {
        try {
            return Double.parseDouble(getText());
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public void setDouble(double val) {
    	super.setText(Double.toString(val));
    }
  
    @Override
    boolean inRange(Double value) {
    	if(range != null) {
        	if(value >= range[0] && value <= range[1]) {
        		return true;
        	}   
        	return false;
    	} else if(positive && value <= 0) {
    		return false;
    	}
    	return true;
    }

	@Override
	public void setRange(Double start, Double stop) {
		range = new Double[] {start, stop};	
		if(start >= 0) {
			positive = true;
		}
	}
}