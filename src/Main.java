import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static KnockOut knock;
    static League league;


    public static void main(String[] args) throws IOException {

        knock = new KnockOut();
        league = new League();


        IO io = new IO();
        UI ui = new UI();
        ui.interact();


        knock.createTournament();

        System.out.println(knock.matchesArrayList);
        System.out.println(knock.teamsArrayList);
        league.createTournament();
        while (ui.UIInteraction!=5) {
            knock.bracketCreator(knock.matchesArrayList);
            knock.updateTournament(knock.matchesArrayList);
            if(ui.UIInteraction == 1){
                io.fileWriter();
            }
            else if(ui.UIInteraction == 4){
                ui.userResultInput(knock.getMatchesArrayList(), knock.teamsArrayList);
            }
            ui.interact();
        }
        }
    }
