package com.ontariotechu.sofe3980U;

import java.util.Date;
import java.util.TimeZone;

public class Timezone extends TimeZone {
    private String timezoneName;
    private int utcOffset;
    
    public Timezone(String name, int offset){
        this.timezoneName=name;
        this.utcOffset=offset;
    }
    public String getTimezoneName(){
	    return this.timezoneName;
    }
    public void setTimezoneName(String name){
	    this.timezoneName=name;
    }
    public int getUtcOffset(){
	    return this.utcOffset;
    }

    @Override
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int milliseconds) {
        return 0;
    }

    @Override
    public void setRawOffset(int offsetMillis) {

    }

    @Override
    public int getRawOffset() {
        return 0;
    }

    @Override
    public boolean useDaylightTime() {
        return false;
    }

    @Override
    public boolean inDaylightTime(Date date) {
        return false;
    }
}