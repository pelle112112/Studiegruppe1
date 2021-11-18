import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class League extends Tournament{

    IO io = new IO();
    ArrayList<Team> teamsArrayList= new ArrayList<Team>();
    ArrayList <Match> matchesArrayList= new ArrayList<Match>();
    ArrayList <Team> ligaStilling = new ArrayList<Team>();
    boolean matchPointCalculator = false;


    @Override
    public void createTournament() throws FileNotFoundException {

        teamsArrayList = io.fileScanner();
        int ID = 1;
        ligaStilling = teamsArrayList;


        for(int counter = 0; counter+1 <= teamsArrayList.size(); counter++){
            for(int i = counter+1; i+1 <= teamsArrayList.size(); i++) {
                if (((Team) teamsArrayList.get(counter)).isInTournament() == true && ((Team) teamsArrayList.get(i)).isInTournament() == true && teamsArrayList.get(counter) != teamsArrayList.get(i)) {
                    this.matchesArrayList.add(new Match(teamsArrayList.get(counter), teamsArrayList.get(i), ID));
                    ID++;
                }
            }

        }

        System.out.println("Liga Matches: " + matchesArrayList.toString());

    }

    public ArrayList<Match> getMatchesArrayList() {
        return matchesArrayList;
    }

    @Override
    public void getScoreBoard() {

        //Sorting League array so the ones with highest points go first

        String leagueTeamStringBuilder = "";

        Collections.sort(ligaStilling, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return o2.currentScore - o1.currentScore;
            }
        });

        System.out.println("____________________________________________________________________________");
        for(int y = 0; y < teamsArrayList.size(); y++){
            for(int i = 0; i < 16; i++){
                if(leagueTeamStringBuilder.length() < 16){
                    leagueTeamStringBuilder+= " ";
                }
            }
            leagueTeamStringBuilder = ligaStilling.get(y).teamName;
            System.out.print("\n" + leagueTeamStringBuilder + " Points:" + ligaStilling.get(y).currentScore + "\n");
        }
        System.out.println("____________________________________________________________________________");


    }

    @Override
    public void updateTournament(ArrayList matches) {

        matchPointReset();
        matchPointsDelegator();
        getScoreBoard();

        
    }



    public void matchPointReset(){
        for(int i = 0; i<matchesArrayList.size(); i++){
            if(matchesArrayList.get(i).winner != null && matchPointCalculator == false){
                matchesArrayList.get(i).winner.currentScore = 0;
            }

        }
    }
    public void matchPointsDelegator(){

        for(int i = 0; i<matchesArrayList.size(); i++){
            if(matchesArrayList.get(i).winner != null && matchPointCalculator == false){
                matchesArrayList.get(i).winner.currentScore += 3;
            }
        }
    }

    @Override
    public String toString() {
        return "League" +
                "ligaStilling: \n" + ligaStilling ;
    }
}
