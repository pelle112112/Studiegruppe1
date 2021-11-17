public class Match {
    Team team1;
    Team team2;
    int matchID;

    Team winner;


    public Match(Team tmpteam1, Team tmpteam2, int tmpID) {
        this.team1 = tmpteam1;
        this.team2 = tmpteam2;
        this.matchID = tmpID;
    }


    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    void findWinner(Team winnerTeam){
        this.winner = winnerTeam;
        if(winnerTeam == team1){
            team2.setInTournament(false);
            System.out.println(winner.toString() + " is a winner!");
        }
        else if(winnerTeam == team2){
            team1.setInTournament(false);
            System.out.println(winner.toString() + " is a winner!");
        }
    }

    void getScore(){
    }
    void addPoints(){

    }
    void readMatchFromFile(){

    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    @Override
    public String toString() {
        return "Match: " + matchID +
                " between: " + team1 +
                " and " + team2 + " \n";
    }
}
