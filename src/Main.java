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
        league.createTournament();
        knock.updateTournament(knock.matchesArrayList);
        while (ui.UIInteraction!=5) {




            if(ui.UIInteraction == 1){
                io.fileWriter();
            }
            else if(ui.UIInteraction == 2){
                knock.bracketCreator(knock.matchesArrayList);
            }
            else if(ui.UIInteraction == 3){
                System.out.println("You have created a League style tournament");
            }
            else if(ui.UIInteraction == 4){
                ui.userResultInput(knock.getMatchesArrayList(), knock.teamsArrayList);
                knock.updateTournament(knock.matchesArrayList);
            }
            ui.interact();
        }
        }
    }
