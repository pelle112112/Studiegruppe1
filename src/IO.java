import java.io.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    Scanner scanner;

    ArrayList fileScanner() throws FileNotFoundException {

        ArrayList <Team> teamArrayList= new ArrayList<>();

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

                teamArrayList.add(new Team (teamName, player1, player2, ID));


            }

        }
        catch (InputMismatchException e){
            System.out.println("Scanner has problems");
        }
        return teamArrayList;
    }

    void fileWriter() throws IOException {

        UI ui = new UI();
        ui.teamUserInput();
        int ID = 1;
        String nextLine = "";
        File file = new File("Data/Tournament.CSV");

        scanner = new Scanner(file);
        scanner.useDelimiter(",");
        while (scanner.hasNextLine()) {
            ID = scanner.nextInt() + 1;
        }

        FileWriter filewriter = new FileWriter(file, true);
        BufferedWriter out = new BufferedWriter(filewriter);

        StringBuilder stringToFile = new StringBuilder();


        out.append(ID+",");
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
