package notebook;

import asg.cliche.Command;

import java.util.ArrayList;
import java.util.List;

public class Notebook {

    private List<Record> records = new ArrayList<>();

    @Command
    public void create(String firstName, String lastName, String phone) {
        Record r = new Record();
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.setPhone(phone);
        records.add(r);
    }

    @Command
    public List<Record> list() {
        return records;
    }
}
