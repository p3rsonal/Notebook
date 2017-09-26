package notebook;

import asg.cliche.Command;
import asg.cliche.Param;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person extends Note{   //extend -> vsjo shto est v rekord'e, teper est i v person'e


    private String firstName;
    private String lastName;
    private String email;
    //  private String[] phone; massiv - ne luchwij variant, luchwe list
    private List<String> phones = new ArrayList<>();

    // alt + insert -> getter and setter, videlit vse  (id, firstname, lastname, phone). Zatem udaljaem setId,
    // tak sdelali eto v counter

    @Command
    public String getFirstName() {
        return firstName;
    }
    @Command
    public void setFirstName(@Param(name = "First Name") String firstName) {
        this.firstName = firstName;
    }
    @Command
    public String getLastName() {
        return lastName;
    }
    @Command
    public void setLastName(@Param(name = "Last Name") String lastName) {
        this.lastName = lastName;
    }
    @Command
    public List<String> getPhones() {
        return phones;
    }
    @Command
    public void addPhones(@Param(name = "Phones") String... phones) {
        Collections.addAll(this.phones, phones);
    }
// getter i setter dlja kolekcii uzhe ne nuzhen
    @Command
    public String getEmail() {
        return email;
    }
    @Command
    public void setEmail(@Param(name = "Email") String email) {
        this.email = email;
    }


    // toString dlja togo, wtobi list vivodil ne hashcode nawih zapisej, a normalnuju zapisj
    @Override
    public String toString() {
        return "Record{" +
                "ID=" + getId() +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Email='" + email + '\'' +
                ", Note=' " + getText() + '\'' +
                ", Phone number(s)=" + phones + '\'';
    }

    @Override
    public boolean contains(String str) {
        String firstNameLower = firstName.toLowerCase();
        String lastNameLower = lastName.toLowerCase();
        String emailLower = email.toLowerCase();

        if (super.contains(str)) {
            return true;
        } else if (lastNameLower.contains(str)) {
            return true;
        } else if (firstNameLower.contains(str)) {
            return true;
        } else if (emailLower.contains(str)) {
            return true;
        } else {
            for (String p : phones) {
                if (p.contains(str)) {   // phones - spisok, p - stroka
                    return true;
                }
            }
        }
        return false;
    }
}
