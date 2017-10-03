package notebook;

import asg.cliche.*;
import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.regexp.internal.RE;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Notebook implements ShellDependent {

    private final NavigableMap<Integer, Record> records = new TreeMap<>();
    //    private List<Record> records = new ArrayList<>();  - pomenjali na hashmap, wtobi uprostit poisk
    private Shell parentShell; // need for cliche to allow subshells

    @Command
    public void createPerson(@Param(name = "First Name") String firstName,
                             @Param(name = "Last Name") String lastName,
                             @Param(name = "Email") String email,
                             @Param(name = "Note") String text,
                             @Param(name = "Phones") String... phones) {
        Person r = new Person();
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.setEmail(email);
        r.setText(text);
        r.addPhones(phones);
        //       records.add(r);  - s hashmap ne rabotaet
        records.put(r.getId(), r);

    }

    @Command
//    public List<Record> list() {
//        return records;

    public Collection<Record> list() {
        return records.values();
    }

    @Command
    public void remove(@Param(name = "Id)") int id) {
//        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(id);
            if (r !=null) {
                records.remove(id);
            }
        }


    @Command
    public void createNote(@Param(name = "Note") String text) {
        Note a = new Note();
        a.setText(text);

        records.put(a.getId(), a);
    }

    @Command
    public void createReminder(@Param(name = "Note") String text,
                               @Param(name = "Time") String time) {
        Reminder b = new Reminder();
        b.setText(text);
        b.setTimeAsString(time);

        records.put(b.getId(), b);
    }

    @Command
    public void createAlarm(@Param(name = "Alarm Name") String text,
                            @Param(name = "Alarm Time") String alarm) {
        Alarm f = new Alarm();
        f.setText(text);
        f.setAlarm(alarm);

        records.put(f.getId(), f);
    }

    @Command
    public void edit(@Param(name = "id") int id) throws IOException {
//        for (int i = 0; i < records.size(); i++) {
        Record r = records.get(id);
        if (r != null) {
            Shell shell = ShellFactory.createSubshell("#" + id, parentShell,
                    "editing\n\t" + r.toString() + "\ntype 'exit' to return to main menu", r);
            shell.commandLoop();
        }
    }



    // need for cliche to allow subshells
    @Override
    public void cliSetShell(Shell theShell) {
        this.parentShell = theShell;
    }

    @Command
    public List<Record> find(@Param(name = "Find") String str) {
        List<Record> result = new ArrayList<>();
        for (Record r : records.values()) {
            if (r.contains(str)) {
                result.add(r);
            }
        }
        return result;
    }

    @Command
    public Collection<Record> range(int start, int end) {
        return records.subMap(start, true, end, true).values();
        }
}
