import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class Team {

    String teamName;
    String player1;
    String player2;
    int teamID;
    int currentScore = 0;
    boolean isInTournament = true;
    KnockOut tourney1 = new KnockOut();

<<<<<<< Updated upstream
=======
    public boolean isInTournament() {
        return isInTournament;
    }

    public void setInTournament(boolean inTournament) {
        isInTournament = inTournament;
    }

>>>>>>> Stashed changes
    public Team(){
    }


    public Team(String teamName, String player1, String player2, int teamID) {
        this.teamName = teamName;
        this.player1 = player1;
        this.player2 = player2;
        this.teamID = teamID;
    }

<<<<<<< Updated upstream

    void getPlayer(){

    }
    void readTeamFromFile(){

    }
    void createTeam(int tmpID, String tmpTeamName, String tmpPlayer1Name, String tmpPlayer2Name){

        Team team = new Team(tmpTeamName, tmpPlayer1Name, tmpPlayer2Name, tmpID);
        tourney1.addTeamtoArraylist(team);
        System.out.println("Team: " + tmpID + " " + tourney1.toString());
    }

    ArrayList<Team> arrayParser (){
        System.out.println("ARRAY PARSER: " + tourney1);
        return tourney1.teamsArrayList;

    }

=======
    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamID=" + teamID +
                '}';
    }
>>>>>>> Stashed changes
}
