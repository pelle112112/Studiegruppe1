public class Team {

    String teamName;
    String player1;
    String player2;
    int teamID;
    int currentScore = 0;
    boolean isInTournament = true;


    public Team(String teamName, String player1, String player2, int teamID) {
        this.teamName = teamName;
        this.player1 = player1;
        this.player2 = player2;
        this.teamID = teamID;
    }


    void getPlayer(){

    }
    void readTeamFromFile(){

    }
    void createTeam(int tmpID, String tmpTeamName, String tmpPlayer1Name, String tmpPlayer2Name){

        Team team = new Team(tmpTeamName, tmpPlayer1Name, tmpPlayer2Name, tmpID);


    }

}
