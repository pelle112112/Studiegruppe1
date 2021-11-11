public class Match {
    Team team1 = new Team();
    Team team2 = new Team();
    int teamcounter = 0;

    Team winner = new Team();

    public Match(){

    }

    public Match(Team team, Team team1) {
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





}
