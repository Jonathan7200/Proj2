import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
                String operation = "placeholder cause java gets angry if its null";
                int num1 = -4;
                int num2 = -4;
                boolean flip = false;

//                System.out.println("testing line: " + line);
                LinkedList list1 = new LinkedList(line.length());
                LinkedList list2 = new LinkedList(line.length());


                if (line !="") {
                    for (String val : line.split("\\s+")) {


                        if (val != "") {
                            // Checking if value is an operator to flip switch to make diff list
                            // Ex: 12 + 42 -> makes linked list [2][1],
                            // then sees +, sets flip = true and starts making second list [2][4]

                            if ("+^*".contains(val)) {

                                operation = val;
                                //                            System.out.println("operation"+ operation);
                                flip = true;
                            }

                            if (flip == false) {
                                num1 = Integer.parseInt(val);
                                for (int i = 0; i < val.length(); i++) {
                                    list1.push(Character.getNumericValue(val.charAt(i)));
                                }
                            } else if (val != operation) {
                                num2 = Integer.parseInt(val);
                                for (int i = 0; i < val.length(); i++) {
                                    list2.push(Character.getNumericValue(val.charAt(i)));

                                }
                            }


                        }//end of If statement, checking when a value isnt a space pretty much
                    } //END OF FOR LOOP Testing to see if lists come out the way intended

                   //Current line
                    //System.out.println("current line: " + line);

                    /**
                     * Add helpers here,
                     * already set up to just plop in.
                     * Useful variables:
                     * list1 is the first number in the line put into a linked-list,
                     * lis2 is the second int.
                     * lists are stored backwards, ex. 46 -> [6][4]. List pop() removes from top and returns Node.
                     */
                    if(operation.equals("+")){
                        //System.out.println("adding working");
                        //ADD HELPER HERE USING list1 & list2 as parameters
                        //int res = add_helper(list1, list2);
                        Node res = addLists(list1, list2);
                        ArrayList<String> temp = new ArrayList<>();
                        while (res != null)
                        {
                            temp.add(Integer.toString(res.getData()));
                            res = res.getNext();
                        }
                        String result = String.join("", temp);
                        System.out.println(num1 + " + " + num2 + " = " + result);

                    }
                    if (operation.equals("*")){
                        //System.out.println("mult working");
                        //ADD HELPER HERE USING list1 & list2 as parameters
                        long res = multiplyLists(list1, list2);
                        System.out.println(num1 + " * " + num2 + " = " + res);
                    }
                    if (operation.equals("^")){
                        //System.out.println("expo working");
                        //ADD HELPER HERE USING list1 & list2 as parameters
                        int res = expo_helper(list1, list2);

                    }
//                    System.out.println("list1 stuff " + "size: " + list1.size()+ " top: "+ list1.peek());
//                    System.out.println("list2 stuff " + "size: " + list2.size()+ " top: "+ list2.peek());





                }
                // else for when line is blank, idk what to do with this yet lol
//                else{
//                    System.out.println("testing for when line is blank");
//                }
//
            }
        }

            catch (FileNotFoundException e) {
                System.out.println("File not found: " + infile.getPath());
        }
    }

    public static int add_helper(LinkedList list1, LinkedList list2){
        return 0;
    }

    public static Node addLists(LinkedList list1, LinkedList list2) {
        int carry = 0;
        Node result = null;

        while (!list1.is_empty() ||
                !list2.is_empty())
        {
            int a = 0, b = 0;

            if (!list1.is_empty())
            {
                a = list1.pop().getData();
            }

            if (!list2.is_empty())
            {
                b = list2.pop().getData();
            }

            int total = a + b + carry;

            Node temp = new Node(total % 10);
            carry = total / 10;

            if (result == null)
            {
                result = temp;
            }
            else
            {
                temp.setNext(result);
                result = temp;
            }
        }

        if (carry != 0)
        {
            Node temp = new Node(carry);
            temp.setNext(result);
            result = temp;
        }
        return result;
    }

    public static int mult_helper(LinkedList list1, LinkedList list2){
        return 0;
    }

    public static long multiplyLists(LinkedList list1, LinkedList list2) {

        long N = 1000000000;
        long number1 = 0;
        long number2 = 0;

        while (list1 != null || list2 !=  null)
        {
            if(!list1.is_empty())
            {
                number1 = (((number1) * 10) % N + list1.pop().getData());
                list1.getNext();
            }

            if(!list2.is_empty())
            {
                number2 = (((number2) * 10) % N + list2.pop().getData());
                list2.getNext();
            }
        }
        return (((number1 % N) *
                (number2 % N)) % N);
    }

    public static int expo_helper(LinkedList list1, LinkedList list2){
        return 0;
    }


}// End of class
