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
                            temp.add(Long.toString(res.getData()));
                            res = res.getNext();
                        }
                        String result = String.join("", temp);
                        System.out.println(num1 + " + " + num2 + " = " + result);

                    }
                    if (operation.equals("*")){
//                        System.out.println("mult running");
                        //ADD HELPER HERE USING list1 & list2 as parameters
                        //long res = multiplyLists(list1, list2);
                        //System.out.println(num1 + " * " + num2 + " = " + res);
                        LinkedList res  = multiList2(list1, list2);
                        System.out.println(num1 + " + " + num2 + " = " + res.numify());

                    }
                    if (operation.equals("^")){
                        //System.out.println("expo running");
                        //ADD HELPER HERE USING list1 & list2 as parameters
                        long res = expoLists(num1, num2);
                        System.out.println(num1 + " ^ " + num2 + " = " + res);

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

    public static Node addLists(LinkedList list1, LinkedList list2) {
        long carry = 0;
        Node result = null;

        while (!list1.is_empty() ||
                !list2.is_empty())
        {
            long a = 0, b = 0;

            if (!list1.is_empty())
            {
                a = list1.pop().getData();
            }

            if (!list2.is_empty())
            {
                b = list2.pop().getData();
            }

            long total = a + b + carry;

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

public static LinkedList multiList2(LinkedList list1, LinkedList list2) {
    LinkedList number1 = list1.flip();
    LinkedList number2 = list2.flip();

    LinkedList result = new LinkedList(number1.size() + number2.size() + 1);

    Node list2Node = number2.getTop();
    Node resNode = result.getTop();

    while (list2Node.getNext() != null) {
        long carry = 0;
        list2Node = resNode;
        Node list1Node = number1.getTop();
    }

    while (list1Node.getNext() != null) {

        long mult = ((list1Node.getData()) * (list2Node.getData()) + carry);


        resNode.setData(resNode.getData() + mult % 10);


        carry = ((mult / 10) + (resNode.getData() / 10));
        resNode.setData(resNode.getData() % 10);

        list1Node = list1Node.getNext();
        resNode = resNode.getNext();
    }
    if (carry > 0):
    resNode.setData(resNode.getData() + carry);
    resNode = resNode.getNext();
    list2Node = list2Node.getNext();

    result = result.flip();
    list1 = list1.flip();
    list2 = list2.flip();


    Node start = result.getTop();
    while (start.getData() == 0) {
        result.setTop(start.getNext());
        start = start.getNext();
    }
    return result;
}
    public static long multiplyLists(LinkedList list0, LinkedList list1) {
        LinkedList temp0 = list0.flip();
        LinkedList temp1 = list1.flip();

        long N = 1000000007L;
        long number1 = 0L;
        long number2 = 0L;

        while (!temp0.is_empty() || !temp1.is_empty())
        {
            if(!temp0.is_empty())
            {
                number1 = (((number1) * 10) % N + temp0.pop().getData());
                temp0.getNext();
            }

            if(!temp1.is_empty())
            {
                number2 = (((number2) * 10) % N + temp1.pop().getData());
                temp1.getNext();
            }
        }
        return (((number1 % N) * (number2 % N)) % N);
    }

    public static long expoLists(int num1, int num2) {
        //System.out.print(list1.toString());
        int N = 1000000007; //prime mod number
        if (num1 == 0)
            return 1;
        if (num2 == 1)
            return num1 % N;
        long num = expoLists(num1, num2 / 2);
        num = (num * num) % N;
        //if exponent is even
        if (num2 % 2 == 0) {
            //System.out.println(num); //for testing purposes
            return num;
        }
            //if exponent is odd
        else {
            //System.out.println(((long) ((num1 % N) * num) % N)); //for testing purposes
            return ((long) ((num1 % N) * num) % N);
        }
    }
}// End of class
