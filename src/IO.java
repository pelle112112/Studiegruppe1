import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    Scanner scanner;

    void fileScanner() throws FileNotFoundException {

        File file = new File("Data/Tournament.CSV");
        scanner = new Scanner(file);
        scanner.useDelimiter(",|\\n");
        String teamName = "", player1 = "", player2 = "";
        int ID = 0;


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

    void fileWriter() throws IOException {



        UI ui = new UI();
        ui.teamUserInput();
        File file = new File("Data/Tournament.CSV");
        scanner = new Scanner(file);
        scanner.useDelimiter(",|\\n");
        FileWriter filewriter = new FileWriter(file, true);
        BufferedWriter out = new BufferedWriter(filewriter);
        int ID = 0, tmpID = 0;

        StringBuilder stringToFile = new StringBuilder();


        out.append(Integer.toString(ID)+",");

        System.out.println(ui.teamName);
        out.append(ui.teamName);
        out.append(',');
        out.append(ui.player1);
        out.append(',');
        out.append(ui.player2);
        out.append("\n");


        out.write(stringToFile.toString());
        out.close();

    }
}
