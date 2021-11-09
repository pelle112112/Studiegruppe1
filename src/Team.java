import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class Team {

    private String teamName;
    private String player1;
    private String player2;
    private  int teamID;
    private  int currentScore = 0;
    private boolean isInTournament = true;
    KnockOut tourney1 = new KnockOut();

    public boolean isInTournament() {
        return isInTournament;
    }



    public Team(){
    }


    public Team(String teamName, String player1, String player2, int teamID) {
        this.teamName = teamName;
        this.player1 = player1;
        this.player2 = player2;
        this.teamID = teamID;
    }

}
