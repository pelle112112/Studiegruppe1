import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static KnockOut knock;
    static League league;
    static DBconnector dbc;
    static IO io;


    static ArrayList<Team> teamArrayList;
    public static void main(String[] args) throws IOException {


        boolean tourneyStyle = false;
        int tourneyCounter = 0;
        knock = new KnockOut();
        league = new League();
        dbc = new DBconnector();


        knock.teamArrayCreator();
        teamArrayList=dbc.readTeamData();
        dbc.writeTeamsToDataBase(knock.teamsArrayList);



        IO io = new IO();
        UI ui = new UI();
        ui.interact();



        knock.updateTournament(knock.teamsArrayList);

        while (ui.UIInteraction!=5) {

                if(ui.UIInteraction == 1) {

                    io.fileWriter();
                    System.out.println("You have written to the file...");
                    //dbc.writeTeamsToDataBase(knock.teamsArrayList);

                }
                else if(ui.UIInteraction == 2) {
                    tourneyStyle = true;

                    if(tourneyCounter == 0){
                        knock.createTournament();
                    }

                    tourneyCounter++;
                }
                else if(ui.UIInteraction == 3) {
                    tourneyStyle = false;

                    if(tourneyCounter == 0){
                        league.createTournament();
                    }
                    league.updateTournament(league.matchesArrayList);
                    tourneyCounter++;

                }

                else if(ui.UIInteraction == 4){
                    if(tourneyStyle == true){
                        ui.userResultInput(knock.getMatchesArrayList(), knock.teamsArrayList);
                        knock.updateTournament(knock.matchesArrayList);
                    }
                    else{
                        ui.userResultInput(league.getMatchesArrayList(), league.teamsArrayList);
                        league.updateTournament(league.matchesArrayList);
                    }
                }
                else if(ui.UIInteraction == 5){
                    System.exit(0);
                }
                else if(ui.UIInteraction == 6){
                    if(tourneyStyle == true){
                        knock.bracketCreator(knock.matchesArrayList);
                    }
                    else {
                        league.updateTournament(league.matchesArrayList);
                    }
                }

                ui.interact();

        }
    }

}