import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IO {
    Scanner scanner;



    //Todo: Read and write .CSV files

    void fileScanner() throws FileNotFoundException {

        File file = new File("Data/Turnering.CSV");
        scanner.useDelimiter(";");
        scanner = new Scanner(file);
        String inputFromFile = "";
        int ID = 0;

        System.out.println("kkkkkkk");


        while (scanner.hasNext()){
            System.out.println("er vi her");

            ID = scanner.nextInt();
            inputFromFile += scanner.next();


        }

    }




}
