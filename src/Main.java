import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        KnockOut knock = new KnockOut();
        League league = new League();
        ArrayList<Team> teamArrayList= new ArrayList<Team>();


        int teamCounter = 0;

        IO io = new IO();
        UI ui = new UI();
        ui.interact();


        knock.createTournament();
        System.out.println(knock.matchesArrayList);
        System.out.println(teamArrayList);
        league.createTournament();
        while (ui.UIInteraction!=5) {


            if(ui.UIInteraction == 1){
                io.fileWriter();
                teamCounter++;
            }
            else if(ui.UIInteraction == 4){
                ui.userResultInput(knock.getMatchesArrayList(), knock.teamsArrayList);
            }

            ui.interact();

        }
        }



    }
