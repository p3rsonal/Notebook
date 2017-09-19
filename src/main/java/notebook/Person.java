package notebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person extends Record{   //extend -> vsjo shto est v rekord'e, teper est i v person'e


    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    //  private String[] phone; massiv - ne luchwij variant, luchwe list
    private List<String> phones = new ArrayList<>();

    // alt + insert -> getter and setter, videlit vse  (id, firstname, lastname, phone). Zatem udaljaem setId,
    // tak sdelali eto v counter

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void addPhones(String... phones) {
        Collections.addAll(this.phones, phones);
    }
// getter i setter dlja kolekcii uzhe ne nuzhen

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // toString dlja togo, wtobi list vivodil ne hashcode nawih zapisej, a normalnuju zapisj
    @Override
    public String toString() {
        return "Record{" +
                "ID=" + getId() +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Email='" + email + '\'' +
                ", Gender='" + gender + '\'' +
                ", Phone numbers=" + phones + '\'';
    }
}
