
import java.io.IOException;
import java.util.Scanner;


public class UI {

    int teamID;
    String teamName;
    String player1;
    String player2;

    int UIInteraction = 0;

    void interact() throws IOException {

        System.out.println("Press 'q' to add a new team or press 'g' to generate a new tournament");

        String input = "";
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        if(input.contains("q")){
            UIInteraction = 1;

        }
        else if(input.contains("g")){

            //todo: Create tournament and dates for each match

            System.out.println("Enter '1' for a knockout-style tournament or '2' for a league-style tournament");
            input = scan.nextLine();
            if(input.contains("1")){
                System.out.println("You have created a knockout-style tournament");
                UIInteraction = 2;
            }
            else if(input.contains("2")){
                System.out.println("You have created a League-style tournament");
                UIInteraction = 3;
            }
        }
    }

    void teamUserInput(){


        int teamID = 0;
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter the name of the team: ");
        this.teamName = scan.nextLine();

        System.out.println("Enter the name of player 1: ");
        this.player1 = scan.nextLine();

        System.out.println("Enter the name of player 2: ");
        this.player2 = scan.nextLine();

    }
}
