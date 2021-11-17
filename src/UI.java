
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




        System.out.println("Press 'g' to create a tournament, 'q' to add a new team, 'w' to enter the result of a game or 'e' to exit.");
        String input = "";
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        if(input.contains("q")){
            UIInteraction = 1;

        }
        else if(input.contains("g")){

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


        else if(input.contains("w")){
            UIInteraction = 4;
        }
        else if(input.contains("e")){
            UIInteraction = 5;
        }


    }

    void teamUserInput(){

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
        int index1 = 0, index2 = 0;
        ArrayList MatchesArraylist;
        ArrayList TeamsArraylist;

        MatchesArraylist = matches;
        TeamsArraylist = teams;


        System.out.println("___________________________________________________________________________________________________________________________");
        System.out.println("Select one of the matches: \n ");


        if(MatchesArraylist.size()==8){
            System.out.println(MatchesArraylist);
        }

        else if (MatchesArraylist.size() == 12){
            for(int i = 8; i<12; i++){
                System.out.println(MatchesArraylist.get(i));
            }
        }

        else if (MatchesArraylist.size() == 14){
            for(int i = 12; i<14; i++){
                System.out.println(MatchesArraylist.get(i));
            }
        }
        else if(MatchesArraylist.size() == 15){
            System.out.println(MatchesArraylist.get(14));
        }
        System.out.println("___________________________________________________________________________________________________________________________");



        Scanner scan = new Scanner(System.in);
        int gameInputInt = Integer.parseInt(gameInput = scan.nextLine());
        int indexOfMatchArray = gameInputInt-1;



        index1 = (TeamsArraylist.indexOf(((Match) MatchesArraylist.get(indexOfMatchArray)).team1));
        index2 = (TeamsArraylist.indexOf(((Match) MatchesArraylist.get(indexOfMatchArray)).team2));



        System.out.println("You have selected match number " + gameInput + "\nWhich of the teams won? \n");
        System.out.println("\n \n" + MatchesArraylist.get(indexOfMatchArray) + "\n");
        System.out.println("___________________________________________________________________________________________________________________________");

        System.out.println("Press 1 for: " + ((Team)TeamsArraylist.get(index1)).getTeamName() + " and 2 for: " + ((Team)TeamsArraylist.get(index2)).getTeamName());
        TeamsArraylist.indexOf(((Match) MatchesArraylist.get(indexOfMatchArray)).team1);


        teamInput = scan.nextLine();

        if(teamInput.contains("1")){

            System.out.println("Team " + ((Team)TeamsArraylist.get(index1)).getTeamName() +" is the winner!\n");
            System.out.println("___________________________________________________________________________________________________________________________");

            ((Team)TeamsArraylist.get(index1+1)).setInTournament(false);
            ((Match)MatchesArraylist.get(gameInputInt-1)).winner = ((Team)TeamsArraylist.get(index1));
        }
        else if(teamInput.contains("2")){

            System.out.println("Team " + ((Team)TeamsArraylist.get(index2)).getTeamName() +" is the winner!");
            System.out.println("___________________________________________________________________________________________________________________________");

            ((Team)TeamsArraylist.get(index2-1)).setInTournament(false);
            ((Match)MatchesArraylist.get(gameInputInt-1)).winner = ((Team)TeamsArraylist.get(index2));
        }
    }

}
