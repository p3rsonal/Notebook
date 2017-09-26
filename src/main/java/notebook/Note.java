package notebook;

import asg.cliche.Command;
import asg.cliche.Param;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Note extends Record {
    private String text;

    @Command
    public String getText() {
        return text;
    }
    @Command
    public void setText(@Param(name = "Note") String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "ID=" + getId() +
                ", Text ='" + text + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        String strLower = str.toLowerCase();
        String textLower = text.toLowerCase();
        return textLower.contains(strLower);
    }
}
