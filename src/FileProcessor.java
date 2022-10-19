import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */


    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {

                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                String operation = null;
                boolean flip = false;
                Stack list_0


            //Still not done, make sure to then split each val into its seperate ints and THEN finally add to linked list as chars
                for (String val : line.split("\\s+")){
                    if(val != ""){
                        // Checking if value is an operator to flip switch to make diff list
                        // Ex: 12 + 42 -> makes linked list [2][1],
                        // then sees +, sets flip = true and starts making second list [2][4]
                        if ("+^*".contains(val)){
                            operation = val;
                            flip = true;}

                        if (flip ==false){
                            //MAKE LIST 1
                        }
                        if (flip == true){
                            //MAKE LIST 2
                        }
                        if(operation == "+"){
                            ///add Helper
                        }
                        if (operation == "*"){
                            //add Helper
                        }
                        if (operation == "^"){
                            //add Helper
                        }




                    System.out.println(word);}
                }

//                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
