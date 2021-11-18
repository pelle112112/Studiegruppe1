import java.io.FileNotFoundException;
import java.util.ArrayList;


public abstract class Tournament {
    ArrayList <Team> teamsArrayList= new ArrayList<Team>();
    ArrayList <Match> matchesArrayList= new ArrayList<Match>();


    public abstract void createTournament() throws FileNotFoundException;

    public abstract void getScoreBoard();

    public abstract void updateTournament(ArrayList matches) throws FileNotFoundException;








}
