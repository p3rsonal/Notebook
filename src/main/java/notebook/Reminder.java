package notebook;

import asg.cliche.Command;
import asg.cliche.Param;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reminder extends Note implements Expirable {
   private LocalDateTime time;
   private static final DateTimeFormatter formatter =
           DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

    public String getTimeAsString() {
        LocalDateTime dt = getTime();
        return dt.format(formatter);
    }

    public void setTimeAsString(String str) {
        LocalDateTime dt = LocalDateTime.parse(str, formatter);
        setTime(dt);
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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

    @Override
    public boolean contains(String str) {
        String strLow = str.toLowerCase();
        return super.contains(strLow)
                || getTimeAsString().toLowerCase().contains(strLow);
    }


    @Override
    public boolean isExpired() {
        return false;
    }
}
