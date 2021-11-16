import java.io.FileNotFoundException;
import java.util.ArrayList;

public class KnockOut extends Tournament{


    IO io = new IO();
    ArrayList<Team> teamsArrayList= new ArrayList<Team>();
    ArrayList <Match> matchesArrayList= new ArrayList<Match>();

    @Override
    public void createTournament() throws FileNotFoundException {

        teamsArrayList = io.fileScanner();
        int ID = 1;

        //todo: The loop has to be changed so it works for more or less than 16 teams
        for(int counter = 0; counter+2 <= teamsArrayList.size(); counter+=2){

            this.matchesArrayList.add(new Match(teamsArrayList.get(counter), teamsArrayList.get(counter+1), ID));
            ID++;

        }
        //System.out.println("Matches: " + matchesArrayList);

        //updateTournament();

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
    public void updateTournament() {


        int variabel = 0;
        for(int i = 0; i< teamsArrayList.size(); i++){
            if(teamsArrayList.get(variabel).isInTournament() == false){
                teamsArrayList.remove(variabel);
            }
        }
    }

    @Override
    public void addTeamtoArraylist(Team team) {
        teamsArrayList.add(team);
    }


}