
import java.io.IOException;
import java.util.Scanner;


public class UI {



    //todo: Interaktion med kunden gennem terminal


    void interact() throws IOException {

        System.out.println("Welcome to the tournament registration");
        System.out.println("Press 'q' to add a new team or press 'g' to generate a new tournament");

        String input = "";
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        if(input.contains("q")){
            System.out.println("you have added a new team!");
        }
        else if(input.contains("g")){

            System.out.println("Enter '1' for a knockout-style tournament or '2' for a league-style tournament");
            input = scan.nextLine();
            if(input.contains("1")){
                System.out.println("You have created a knockout-style tournament");
            }
            else if(input.contains("2")){
                System.out.println("You have created a League-style tournament");
            }
        }


    }





}
