package notebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Record {

    private static int counter = 0;
    // wtobi objavit peremenuju globalnoj (obchej, to est dostupnoj vsem) dobavljaem "static"
    private int id;

    public Record() {           // alt + insert -> constructor -> select none
        counter++;
        id = counter;
    }

    public int getId() {
        return id;
    }

    public abstract boolean contains(String str);

}



