package com.ontariotechu.sofe3980U;

public class Preferences {
    private boolean use12HourFormat;

    public Preferences(boolean use12HourFormat) {
        this.use12HourFormat = use12HourFormat;
    }

    public void setUse12HourFormat(boolean use12HourFormat) {
        this.use12HourFormat = use12HourFormat;
    }

    public boolean isUsing12HourFormat() {
        return this.use12HourFormat;
    }

    @Override
    public String toString() {
        return "Preferences{" +
                "use12HourFormat=" + use12HourFormat +
                '}';
    }
}

/* Justin
package com.ontariotechu.sofe3980U;

public class Preferences {
    private boolean use12HourFormat;

    public Preferences(boolean use12HourFormat){
	    this.use12HourFormat=use12HourFormat;
    }
    public void setPreference(boolean pref){
	    this.use12HourFormat=pref;
    }
    public boolean getPreference(){
	    return this.use12HourFormat;
    }
}

 */