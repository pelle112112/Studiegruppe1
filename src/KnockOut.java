import java.util.ArrayList;

public class KnockOut extends Tournament{

    //todo: Create matches. (Theres always gonna be 15 matches in a knockout tourney with 16 teams.


    IO io = new IO();
    ArrayList<Team> teamsArrayList= new ArrayList<Team>();
    ArrayList <Match> matchesArrayList= new ArrayList<Match>();






<<<<<<< Updated upstream
=======
        }
        System.out.println("Matches: " + matchesArrayList);
        matchResultUpdater();
        getScoreBoard();


        for(int i = 0; i<teamsArrayList.size(); i++) {
            System.out.println(teamsArrayList.get(i).toString());
        }


>>>>>>> Stashed changes






    @Override
    public void createTournament() {
        //todo: create knockout tournament
        KnockOut knockout1 = new KnockOut();
    }

    @Override
    public void getScoreBoard() {
        for(int i = 0; i<teamsArrayList.size(); i++){
            if(teamsArrayList.get(i).isInTournament() == false){
                System.out.println(teamsArrayList.get(i).toString() + "IS NOT IN THE TOURNAMENT");
            }
        }


    }

    @Override
    public void updateTournament() throws FileNotFoundException {

<<<<<<< Updated upstream
=======

        int v1 = 0, v2 = 1;


        //todo: The loop has to be changed so it works for more or less than 16 teams

        while(teamsArrayList.iterator().hasNext() && v1 != 8){
            if(teamsArrayList.get(v1).isInTournament() == false){
                teamsArrayList.remove(v1);
            }
            matchesArrayList.add(new Match(teamsArrayList.get(v1), teamsArrayList.get(v2)));
            v1+= 2;
            v2+=2;

        }


    }

    public void matchResultUpdater() throws FileNotFoundException {

        matchesArrayList.get(0).findWinner(teamsArrayList.get(1));
        matchesArrayList.get(1).findWinner(teamsArrayList.get(3));
        matchesArrayList.get(2).findWinner(teamsArrayList.get(5));
        matchesArrayList.get(3).findWinner(teamsArrayList.get(7));
        matchesArrayList.get(4).findWinner(teamsArrayList.get(9));
        matchesArrayList.get(5).findWinner(teamsArrayList.get(11));
        matchesArrayList.get(6).findWinner(teamsArrayList.get(13));
        matchesArrayList.get(7).findWinner(teamsArrayList.get(15));
        int variabel = 0;
        for(int i = 0; i< teamsArrayList.size(); i++){
            if(teamsArrayList.get(variabel).isInTournament() == false){
                teamsArrayList.remove(variabel);
            }
        }
        updateTournament();

>>>>>>> Stashed changes
    }

    @Override
    public void addTeamtoArraylist(Team team) {
        teamsArrayList.add(team);
    }
}
