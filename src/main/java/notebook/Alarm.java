package notebook;

import asg.cliche.Command;
import asg.cliche.Param;

public class Alarm extends Note implements Expirable {
    private String alarm;

    @Command
    public String getAlarm() {return alarm;}

    @Command
    public void setAlarm(@Param(name = "Alarm time") String alarm) {this.alarm = alarm;}

    @Override
    public String toString() {
        return "Alarm{" +
                "ID=" + getId() +
                ", Alarm Name ='" + getText() + '\'' +
                ", Alarm Time='" + alarm + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        String alarmLower = alarm.toLowerCase();
        if (super.contains(str)) {
            return true;
        } else if (alarmLower.contains(str)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
