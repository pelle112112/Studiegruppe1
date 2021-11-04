import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        int input = 0;
        Team team;

        IO io = new IO();
        io.fileScanner();
        UI ui = new UI();
        ui.interact();

        switch (ui.UIInteraction){
            case 1:
                //todo: create team
                io.fileWriter();
                break;
            case 2:
                //todo: create knockout tournament
                break;
            case 3:
                //todo: create League tournament
                break;
        }

    }
}
