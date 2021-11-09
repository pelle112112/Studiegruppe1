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

        switch (ui.UIInteraction){
            case 1:
                //todo: create team

                io.fileWriter();
                teamCounter++;
                ui.interact();
                break;
            case 2:
                knock.createTournament();


                System.out.println(teamArrayList);



                //todo: create knockout tournament

                break;
            case 3:
                league.createTournament();

                //todo: create League tournament
                break;

            //todo: Create a 4th option for the user to change the matchresult
        }

    }
}
