package notebook;

import asg.cliche.Command;
import asg.cliche.Param;

public class Reminder extends Note{
    private String time;

    @Command
    public String getTime() {
        return time;
    }
    @Command
    public void setTime(@Param(name = "Time") String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "ID=" + getId() +
                ", Task ='" + getText() + '\'' +
                ", Time ='" + time + '\'' +
                '}';
    }
}
