package notebook;

import asg.cliche.Command;
import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class Notebook {

    private List<Record> records = new ArrayList<>();

    @Command
    public void create(String firstName, String lastName, String email, String gender, String ... phone) {
        Record r = new Record();
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.setEmail(email);
        r.setGender(gender);
        r.setPhone(phone);
        records.add(r);

    }

    @Command
    public List<Record> list() {
        return records;
    }

    @Command
    public void remove(int id) {
        records.remove(int id);

    }
}
