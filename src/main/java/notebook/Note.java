package notebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Note extends Record {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "ID=" + getId() +
                ", Text ='" + text + '\'' +
                '}';
    }
}
