package notebook;

import asg.cliche.Command;
import asg.cliche.Param;

public class Reminder extends Note implements Expirable {
    private String time;

    @Command
    public String getTime() {
        return time;
    }
    @Command
    public void setTime(@Param(name = "Time") String time) {this.time = time;}

    @Override
    public String toString() {
        return "Reminder{" +
                "ID=" + getId() +
                ", Task ='" + getText() + '\'' +
                ", Time ='" + time + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        String timeLower = time.toLowerCase();
        if (super.contains(str)) {
            return true;
        } else if (timeLower.contains(str)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
