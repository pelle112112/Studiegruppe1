import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    Scanner scanner;



    //Todo: Read and write .CSV files

    void fileScanner() throws FileNotFoundException {

        File file = new File("Data/Turnering.CSV");

        scanner = new Scanner(file);
        scanner.useDelimiter(",|\\n");
        String teamName = "", player1 = "", player2 = "";
        int ID = 0;

        System.out.println("kkkkkkk");

        try{
            while (scanner.hasNext()) {

                ID = scanner.nextInt();
                teamName = scanner.next();
                player1 = scanner.next();
                player2 = scanner.next();
                System.out.println("ID = " + ID + " teamname = " + teamName + " player 1 = " + player1 + " Player 2 = " + player2);

            }
        }
        catch (InputMismatchException e){
            System.out.println("Scanner has problems");
        }

    }




}
