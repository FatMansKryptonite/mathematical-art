package application.view.util;

public class IntField extends RestrictedField<Integer> {
		
	public boolean positive = false;	

    public IntField(String promptText, int defaultText, String tip) {
        super(promptText, Integer.toString(defaultText), tip);
    }
    
    public IntField(String promptText, int defaultText) {
        super(promptText, Integer.toString(defaultText));
    }

    boolean isValid(final String value) {
        if (value.length() == 0 || (value.equals("-") && !positive)) {
            return true;
        }

        try {
            @SuppressWarnings("unused")
			Integer val = Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getInt() {
        try {
            Integer ret = Integer.parseInt(getText());
            if(inRange(ret)) {
            	return ret;
            } else {
            	if(ret < range[0]) {
            		setInt(range[0]);
            		return getInt();
            	} else {
            		setInt(range[1]);
            		return getInt();
            	}
            }
        } catch (NumberFormatException e) {
            return 1;
        }
    }
    
    public void setInt(int val) {
    	super.setText(Integer.toString(val));
    }
    
    @Override
    boolean inRange(Integer value) {
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
	public void setRange(Integer start, Integer stop) {
		range = new Integer[] {start, stop};	
		if(start >= 0) {
			positive = true;
		}
	}
}