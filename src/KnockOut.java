import java.io.FileNotFoundException;
import java.util.ArrayList;

public class KnockOut extends Tournament{


    IO io = new IO();
    ArrayList<Team> teamsArrayList= new ArrayList<Team>();
    ArrayList <Match> matchesArrayList= new ArrayList<Match>();

    @Override
    public void createTournament() throws FileNotFoundException {


        teamsArrayList = io.fileScanner();
        int v1 = 0, v2 = 1;


        //todo: The loop has to be changed so it works for more or less than 16 teams
        while(teamsArrayList.iterator().hasNext() && v1 != 16){
            matchesArrayList.add(new Match(teamsArrayList.get(v1), teamsArrayList.get(v2)));
            v1+= 2;
            v2+=2;

        }
        System.out.println("Matches: " + matchesArrayList);
        updateTournament();

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