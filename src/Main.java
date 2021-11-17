import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Team> teamArrayList;
    public static void main(String[] args) throws IOException {

        KnockOut knock = new KnockOut();
        League league = new League();
        DBconnector dbc = new DBconnector();
        //kun i main



        teamArrayList=dbc.readTeamData();




        int teamCounter = 0;


        IO io = new IO();
        UI ui = new UI();
        ui.interact();

        switch (ui.UIInteraction){
            case 1:
                //todo: create team

                //io.fileWriter();
                dbc.writeTeamsToDataBase(knock.teamsArrayList);
                teamCounter++;
                break;
            case 2:
                knock.createTournament();
                dbc.writeTeamsToDataBase(knock.teamsArrayList);


                System.out.println(teamArrayList);



                //todo: create knockout tournament

                break;
            case 3:
                league.createTournament();

                //todo: create League tournament
                break;

            //todo: Create a 4th option for the user to change the matchresult
        }

        // Todo vi skal lave en database
    }

}