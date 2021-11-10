import java.util.ArrayList;


public abstract class Tournament {
    ArrayList <Team> teamsArrayList= new ArrayList<Team>();
    ArrayList <Match> matchesArrayList= new ArrayList<Match>();


    public abstract void createTournament();

    public abstract void getScoreBoard();

    public abstract void updateTournament() throws FileNotFoundException;

    public abstract void addTeamtoArraylist(Team team);








}
