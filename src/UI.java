
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class UI {

    int teamID;
    String teamName;
    String player1;
    String player2;
    KnockOut knock1 = new KnockOut();

    int UIInteraction = 0;

    void interact() throws IOException {

        System.out.println("Press 'q' to add a new team, press 'w' to enter the result of a game or press 'E' to exit!");

        String input = "";
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        if(input.contains("q")){
            UIInteraction = 1;

        }
        /*else if(input.contains("g")){

            //todo: Create tournament and dates for each match

            System.out.println("Enter '1' for a knockout-style tournament or '2' for a league-style tournament");
            input = scan.nextLine();
            if(input.contains("1")){
                System.out.println("You have created a knockout-style tournament");
                UIInteraction = 2;
            }
            else if(input.contains("2")){
                System.out.println("You have created a League-style tournament");
                UIInteraction = 3;
            }
        }
        */

        else if(input.contains("w")){
            UIInteraction = 4;
        }
        else if(input.contains("e")){
            UIInteraction = 5;
        }


    }

    void teamUserInput(){


        int teamID = 0;
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter the name of the team: ");
        this.teamName = scan.nextLine();

        System.out.println("Enter the name of player 1: ");
        this.player1 = scan.nextLine();

        System.out.println("Enter the name of player 2: ");
        this.player2 = scan.nextLine();

    }


    void userResultInput(ArrayList<Match> matches, ArrayList<Team> teams) throws FileNotFoundException {


        String gameInput = "", teamInput = "";
        int index1, index2;
        ArrayList MatchesArraylist = new ArrayList<>();
        ArrayList TeamsArraylist = new ArrayList();

        MatchesArraylist = matches;
        TeamsArraylist = teams;



        System.out.println("Select one of the matches: \n " + MatchesArraylist);

        Scanner scan = new Scanner(System.in);
        int gameInputInt = Integer.parseInt(gameInput = scan.nextLine());


        System.out.println("You have selected match number " + gameInput + "\nWhich of the teams won? \n");
        System.out.println(MatchesArraylist.get(gameInputInt - 1) + "\n");


        System.out.println("Press 1 for: " + ((Team)TeamsArraylist.get(2*gameInputInt-2)).getTeamName() + " and 2 for: " + ((Team)TeamsArraylist.get(2*gameInputInt-1)).getTeamName());
        //System.out.println("MATCH TEAM: " + ((Match)MatchesArraylist.get(gameInputInt)).team1);
        TeamsArraylist.indexOf(((Match) MatchesArraylist.get(gameInputInt)).team1);


        teamInput = scan.nextLine();

        if(teamInput.contains("1")){
            index1 = (TeamsArraylist.indexOf(((Match) MatchesArraylist.get(gameInputInt)).team1))-2;
            System.out.println("INDEX UDREGNING: " + index1);
            System.out.println("Team " + ((Team)TeamsArraylist.get(index1)).getTeamName() +" is the winner!");

            ((Team)TeamsArraylist.get(index1+1)).setInTournament(false);
            ((Match)MatchesArraylist.get(gameInputInt-1)).winner = ((Team)TeamsArraylist.get(index1));
        }
        else if(teamInput.contains("2")){
            index2 = (TeamsArraylist.indexOf(((Match) MatchesArraylist.get(gameInputInt)).team2))-2;
            System.out.println("INDEX UDREGNING: " + index2);
            System.out.println("Team " + ((Team)TeamsArraylist.get(index2)).getTeamName() +" is the winner!");
            
            ((Team)TeamsArraylist.get(index2-1)).setInTournament(false);
            ((Match)MatchesArraylist.get(gameInputInt-1)).winner = ((Team)TeamsArraylist.get(index2));
        }



    }
}
