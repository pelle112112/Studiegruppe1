import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class KnockOut extends Tournament{


    IO io = new IO();
    ArrayList<Team> teamsArrayList= new ArrayList<Team>();
    ArrayList <Match> matchesArrayList= new ArrayList<Match>();

    @Override
    public void createTournament() throws FileNotFoundException {

        teamsArrayList = io.fileScanner();
        int ID = 1;

        //todo: The loop has to be changed so it works for more or less than 16 teams
        for(int counter = 0; counter+2 <= teamsArrayList.size(); counter+=2){
            if(((Team)teamsArrayList.get(counter)).isInTournament() == true && ((Team)teamsArrayList.get(counter+1)).isInTournament() == true){
                this.matchesArrayList.add(new Match(teamsArrayList.get(counter), teamsArrayList.get(counter+1), ID));
                ID++;
            }
        }
        System.out.println("Knockout Matches: " + matchesArrayList.toString());

    }

    public void bracketCreator(ArrayList matches){

        int matchesLeft = 15, counter = 1, arrayCounter= 7, arrayCounter2 = 11;
        String team1 = "", team2 = "", winner = "", winner2 = "";

        ArrayList<String> vinderArray = new ArrayList();


        if (matchesArrayList.size() >= 8) {

            for (int i = 0; i < matchesArrayList.size() - 2; i++) {

                if(matchesArrayList.get(i).winner.teamName == null){
                    vinderArray.set(i, "ingenVinder");
                }
                vinderArray.set(i, matchesArrayList.get(i).winner.teamName);
            }
        }

        if(teamsArrayList.size() == 16){
            System.out.println("Round 1 matches are being processed...");

            for(int i = 0; i<matches.size(); i++) {


                team1 = ((Match)matchesArrayList.get(i)).team1.teamName;
                team2 = ((Match)matchesArrayList.get(i)).team2.teamName;
                for(int y = 0; y < 16; y++){
                    if(team1.length() < 13){
                        team1+= " ";
                    }
                }
                for(int y = 0; y < 16; y++){
                    if(team2.length() < 13){
                        team2+= " ";
                    }
                }
                System.out.println(team1 + " --------------");


                System.out.println("                           |");
                System.out.println(team2 + " --------------");

                System.out.println("");
                System.out.println("\n");

            }
        }
        else if(teamsArrayList.size() == 8){
            for(int i = 0; i<8; i++) {
                counter++;


                team1 = ((Match)matchesArrayList.get(i)).team1.teamName;
                team2 = ((Match)matchesArrayList.get(i)).team2.teamName;
                winner = matchesArrayList.get(i).winner.teamName;

                for(int y = 0; y < 16; y++){
                    if(team1.length() < 13){
                        team1+= " ";
                    }
                }
                for(int y = 0; y < 16; y++){
                    if(team2.length() < 13){
                        team2+= " ";
                    }
                    if(winner.length() < 14){
                        winner+= " ";
                    }
                }
                System.out.println(team1 + " --------------");
                System.out.println("                           |  " + winner +  "--------------");
                System.out.println(team2 + " --------------");

                if(i != 7 && counter % 2 == 0) {
                    System.out.println("                                                         |");
                    System.out.println("                                                         |");
                    System.out.println("                                                         |");
                }
                if(counter % 2 != 0){
                    System.out.println("\n \n \n");
                }
            }
        }


        else if(teamsArrayList.size() == 4){
            counter = 1;
            for(int i = 0; i<8; i++) {
                counter++;



                team1 = ((Match)matchesArrayList.get(i)).team1.teamName;
                team2 = ((Match)matchesArrayList.get(i)).team2.teamName;
                winner = matchesArrayList.get(i).winner.teamName;
                if (i < 4) {
                    winner2 = matchesArrayList.get(i+8).winner.teamName;
                }

                for(int y = 0; y < 16; y++){
                    if(team1.length() < 13){
                        team1+= " ";
                    }
                }
                for(int y = 0; y < 16; y++){
                    if(team2.length() < 13){
                        team2+= " ";
                    }
                    if(winner.length() < 14){
                        winner+= " ";
                    }
                }
                if(i < 8) {
                    System.out.println(team1 + " --------------");
                    System.out.println("                           |  " + winner + "--------------");
                    System.out.println(team2 + " --------------");
                }
                if(i != 7 && counter % 2 == 0) {
                    arrayCounter++;
                    System.out.println("                                                         |");
                    System.out.println("                                                         |" + vinderArray.get(arrayCounter));
                    System.out.println("                                                         |");
                }
                if(counter % 2 != 0 && i<8){
                    System.out.println("\n \n \n");
                }
            }
        }
        else if(teamsArrayList.size() == 2){
            for(int i = 0; i<8; i++) {
                counter++;



                team1 = ((Match)matchesArrayList.get(i)).team1.teamName;
                team2 = ((Match)matchesArrayList.get(i)).team2.teamName;
                winner = matchesArrayList.get(i).winner.teamName;
                if (i < 4) {
                    winner2 = matchesArrayList.get(i+8).winner.teamName;
                }

                for(int y = 0; y < 16; y++){
                    if(team1.length() < 13){
                        team1+= " ";
                    }
                }
                for(int y = 0; y < 16; y++){
                    if(team2.length() < 13){
                        team2+= " ";
                    }
                    if(winner.length() < 14){
                        winner+= " ";
                    }
                }
                if(i < 8) {
                    System.out.println(team1 + " --------------");
                    System.out.println("                           |  " + winner + "--------------");
                    System.out.println(team2 + " --------------");
                }
                if(i != 7 && counter % 2 == 0) {
                    arrayCounter++;
                    System.out.println("                                                         |");
                    System.out.println("                                                         |" + vinderArray.get(arrayCounter));
                    System.out.println("                                                         |");
                }
                if(counter % 2 != 0 && i<8){
                    System.out.println("\n \n \n");
                }

            }
        }





    }


    public void setMatchesArrayList(ArrayList<Match> matchesArrayList) {
        this.matchesArrayList = matchesArrayList;
    }

    public ArrayList<Match> getMatchesArrayList() {

        return this.matchesArrayList;
    }

    @Override
    public void getScoreBoard() {

    }

    @Override
    public void updateTournament(ArrayList matches) {

        //todo: Has to check all matches if theres a winner!

        int matchesLeft = 15, ID = 9, tournamentRound = 1;

        for(int i = 0; i<teamsArrayList.size(); i++){
            if(((Team)teamsArrayList.get(i)).isInTournament == false){

                this.teamsArrayList.remove(i);
            }
        }

        for(int i = 0; i<matchesArrayList.size(); i++){
            if(((Match)matchesArrayList.get(i)).winner != null){
                matchesLeft--;
            }

        }

        if(matchesLeft == 7 || matchesLeft == 3 || matchesLeft == 1){

            if(matchesLeft == 3){
                ID = 13;
                tournamentRound = 2;
            }
            if (matchesLeft == 1){
                ID = 15;
                tournamentRound = 3;
            }

            System.out.println("Round " + tournamentRound + " matches have been played. Next round and matches are being processed...\n \n");


            for(int counter = 0; counter+2 <= this.teamsArrayList.size(); counter+=2){
                    matchesArrayList.add(new Match(this.teamsArrayList.get(counter), this.teamsArrayList.get(counter+1), ID));
                    ID++;
            }

            if (matchesLeft == 7){
                for(int i = 8; i<12; i++){
                    System.out.println("Quarter finals: " + matchesArrayList.get(i));
                }
            }

            else if (matchesLeft == 3){
                for(int i = 12; i<14; i++){
                    System.out.println("Semi Finals: " + matchesArrayList.get(i));
                }
            }
            else if(matchesLeft == 1){
                System.out.println("Finale: " + matchesArrayList.get(14));
            }


        }
    }

    @Override
    public void addTeamtoArraylist(Team team) {
        teamsArrayList.add(team);
    }


}