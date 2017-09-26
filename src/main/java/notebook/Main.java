package notebook;

import asg.cliche.Shell;
import asg.cliche.ShellFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Notebook commands = new Notebook();
        Shell shell = ShellFactory.createConsoleShell(
                "cmd",
                "Notebook. Saving your contacts.\n Type '?list' to see command list.\n Type 'exit' to quit app.",
                commands);
        shell.commandLoop();


    }
}
