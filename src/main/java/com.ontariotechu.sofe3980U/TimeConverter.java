package com.ontariotechu.sofe3980U;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeConverter {
     public String convertTime(String inputTime, ZoneId sourceZone, ZoneId targetZone) {
        LocalDateTime localDateTime = LocalDateTime.parse(inputTime, DateTimeFormatter.ofPattern("HH:mm"));
        ZonedDateTime sourceDateTime = ZonedDateTime.of(localDateTime, sourceZone);
        ZonedDateTime targetDateTime = sourceDateTime.withZoneSameInstant(targetZone);
        return targetDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        }
    public String convert24HourTimeTo12Hour(String inputTime) {
        LocalTime time = LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("HH:mm"));
        return time.format(DateTimeFormatter.ofPattern("h:mm a"));
    }
    public String convert12HourTimeTo24Hour(String inputTime) {
        LocalTime time = LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("h:mm a"));
        return time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

}

/* Justin
package com.ontariotechu.sofe3980U;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//logic to be implemented later TDD
public class TimeConverter {
    public String convertTime(String inputTime, Timezone sourceTimezone, Timezone targetTimezone) {
        return "22:00";
    }
    public String convert24HourTime(String inputTime){
        return "7:00 pm";
    }
    public String convert12HourTime(String inputTime){
        return "19:00";
    }
}



 */
