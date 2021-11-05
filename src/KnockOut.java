import java.util.ArrayList;

public class KnockOut extends Tournament{

    //todo: Create matches. (Theres always gonna be 15 in a knockout tourney with 16 teams.

    ArrayList<Team> teamsArrayList= new ArrayList<Team>();
    ArrayList <Match> matchesArrayList= new ArrayList<Match>();





    @Override
    public void createTournament() {
        //todo: create knockout tournament
        KnockOut knockout1 = new KnockOut();
    }

    @Override
    public void getScoreBoard() {

    }

    @Override
    public void updateTournament() {

    }

    @Override
    public void addTeamtoArraylist(Team team) {
        teamsArrayList.add(team);
    }
}
