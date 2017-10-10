package notebook;

import asg.cliche.Command;
import asg.cliche.Param;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Alarm extends Note implements Expirable {
    private LocalTime alarm;
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("HH:mm");

    public String getAlarmAsString() {
        LocalTime dt = getAlarm();
        return dt.format(formatter);
    }

    public void setAlarmAsString(String str) {
        LocalTime dt = LocalTime.parse(str, formatter);
        setAlarm(dt);
    }

    @Command
    public LocalTime getAlarm() { return alarm; }
    @Command
    public void setAlarm(@Param(name = "Time") LocalTime alarm) { this.alarm = alarm; }

    @Override
    public String toString() {
        return "Alarm{" +
                "ID=" + getId() +
                ", Alarm Name ='" + getText() + '\'' +
                ", Alarm Time='" + getAlarmAsString() + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        String strLow = str.toLowerCase();
        return super.contains(strLow)
                || getAlarmAsString().toLowerCase().contains(strLow);
    }

    @Override
    public boolean isExpired() {
        LocalTime now = LocalTime.now();
        return now.isAfter(alarm);
    }
}
