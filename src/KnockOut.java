import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class KnockOut extends Tournament{


    IO io = new IO();
    ArrayList<Team> teamsArrayList= new ArrayList<Team>();
    ArrayList <Match> matchesArrayList= new ArrayList<Match>();

    @Override
    public void createTournament() throws FileNotFoundException {

        teamsArrayList = io.fileScanner();
        int ID = 1, counter2 = 1;

        //todo: The loop has to be changed so it works for more or less than 16 teams
        for(int counter = 0; counter+2 <= teamsArrayList.size(); counter+=2){
            if(((Team)teamsArrayList.get(counter)).isInTournament() == true && ((Team)teamsArrayList.get(counter+1)).isInTournament() == true){
                this.matchesArrayList.add(new Match(teamsArrayList.get(counter), teamsArrayList.get(counter+1), ID));
                ID++;
            }


        }

    }

    public void bracketCreator(ArrayList matches){

        int matchesLeft = 0, teamNameLength = 0;
        String team1 = "", team2 = "";



        if(matchesLeft == 8){
            System.out.println("Round 1 matches are being processed...");
        }


        for(int i = 0; i<matches.size(); i++) {


            team1 = ((Match)matches.get(i)).team1.teamName;
            team2 = ((Match)matches.get(i)).team2.teamName;
            for(int y = 0; y < 16; y++){
                if(team1.length() < 13){
                    team1+= " ";
                }
            }
            for(int y = 0; y < 16; y++){
                if(team2.length() < 13){
                    team2+= " ";
                }
            }
            System.out.println(team1 + " --------------");


            System.out.println("                           |");
            System.out.println(team2 + " --------------");

            System.out.println("");
            System.out.println("\n");

        }

        if(matches.size() == 4){
            System.out.println("OIOIOIOIOIOIOIOIOIOIOI");
        }

    }


    public void setMatchesArrayList(ArrayList<Match> matchesArrayList) {
        this.matchesArrayList = matchesArrayList;
    }

    public ArrayList<Match> getMatchesArrayList() {

        return this.matchesArrayList;
    }

    @Override
    public void getScoreBoard() {

    }

    @Override
    public void updateTournament(ArrayList matches) {

        //todo: Has to check all matches if theres a winner!

        int matchesLeft = 15, ID = 9, tournamentRound = 1;
        ArrayList<Match> newMatchArray = new ArrayList();

        for(int i = 0; i<teamsArrayList.size(); i++){
            if(((Team)teamsArrayList.get(i)).isInTournament == false){
                System.out.println("YOU WANT TO REMOVE: " + teamsArrayList.get(i));
                this.teamsArrayList.remove(i);
            }
        }

        for(int i = 0; i<matchesArrayList.size(); i++){
            if(((Match)matchesArrayList.get(i)).winner != null){
                matchesLeft--;
            }

        }
        System.out.println("MATCHES LEFT: " + matchesLeft);
        if(matchesLeft == 7 || matchesLeft == 3 || matchesLeft == 1){

            if(matchesLeft == 3){
                ID = 13;
            }
            if (matchesLeft == 1){
                ID = 15;
            }
            System.out.println("Round " + tournamentRound + " matches have been played. Next round and matches are being processed...");

            for(int counter = 0; counter+2 <= this.teamsArrayList.size(); counter+=2){
                    matchesArrayList.add(new Match(this.teamsArrayList.get(counter), this.teamsArrayList.get(counter+1), ID));
                    ID++;
            }
            System.out.println("New Matches: " + matchesArrayList.toString());
            tournamentRound++;
        }
    }

    @Override
    public void addTeamtoArraylist(Team team) {
        teamsArrayList.add(team);
    }


}