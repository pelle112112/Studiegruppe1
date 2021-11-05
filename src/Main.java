import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Match matchCreator = new Match();
        KnockOut knock = new KnockOut();
        League league = new League();
        Team teamCreater = new Team();
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
                io.fileScanner();
                teamArrayList = teamCreater.arrayParser();

                    System.out.println("teamArraylist: " + teamArrayList);


                //todo: create knockout tournament

                break;
            case 3:
                league.createTournament();

                //todo: create League tournament
                break;
        }

    }
}
