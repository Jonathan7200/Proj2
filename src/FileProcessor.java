import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
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
        ArrayList<String> output = new ArrayList<>();
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
                        String stepString = (num1 + " + " + num2 + " = " + result);
                        output.add(stepString);

                    }
                    if (operation.equals("*")){
//                        System.out.println("mult running");
                        //ADD HELPER HERE USING list1 & list2 as parameters
                        String res = multiplyLists_test(list1, list2);
                        //System.out.println(num1 + " * " + num2 + " = " + res);
                        String stepString = (num1 + " * " + num2 + " = " + res);
                        output.add(stepString);
                        //LinkedList res  = multiList2(list1, list2);
                        //System.out.println(num1 + " + " + num2 + " = " + res.numify());

                    }
                    if (operation.equals("^")){
                        //System.out.println("expo running");
                        //ADD HELPER HERE USING list1 & list2 as parameters
                        String res = expoLists_1(Integer.toString(num1), Integer.toString(num2));
                        //System.out.println(num1 + " ^ " + num2 + " = " + res);
                        String stepString = (num1 + " ^ " + num2 + " = " + res);
                        output.add(stepString);

                    }
//                    System.out.println("list1 stuff " + "size: " + list1.size()+ " top: "+ list1.peek());
//                    System.out.println("list2 stuff " + "size: " + list2.size()+ " top: "+ list2.peek());




                }

            }
        }

            catch (FileNotFoundException e) {
                System.out.println("File not found: " + infile.getPath());
        }
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i));
            if (i != output.size()-1) {System.out.print("\n");}
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
/* //outdated code, improved version made and used
    public static long multiplyLists(LinkedList list0, LinkedList list1) {
        LinkedList temp0 = list0.flip();
        LinkedList temp1 = list1.flip();

        long N = 8717861568456214667l;
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

 */

    public static String multiplyLists_test(LinkedList list1, LinkedList list0) {
        LinkedList temp_list0 = list0.flip();
        LinkedList temp_list1 = list1.flip();

        BigInteger N = new BigInteger("5836090530224727663398555102196101238110440949348712473760677766722525717734801063298409008551326821");
        BigInteger number1 = new BigInteger("0");
        BigInteger number2 = new BigInteger("0");

        while (!temp_list0.is_empty() || !temp_list1.is_empty())
        {
            if(!temp_list0.is_empty())
            {
                BigInteger temp_0 = number1.multiply(BigInteger.valueOf(10));
                BigInteger temp_node = BigInteger.valueOf(temp_list0.pop().getData());
                BigInteger temp_0_into_mod = temp_0.mod(N);
                number1 = temp_0_into_mod.add(temp_node);

                temp_list0.getNext();
            }
            if(!temp_list1.is_empty())
            {
                BigInteger temp_0 = number2.multiply(BigInteger.valueOf(10));
                BigInteger temp_node = BigInteger.valueOf(temp_list1.pop().getData());
                BigInteger temp_0_into_mod = temp_0.mod(N);
                number2 = temp_0_into_mod.add(temp_node);

//                number2 = (((number2) * 10) % N + temp1.pop().getData());
                temp_list1.getNext();
            }
        }
        BigInteger num_1 = number1.mod(N);
        BigInteger num_2 = number2.mod(N);
        BigInteger res = num_1.multiply(num_2);
        res = res.mod(N);

//        return (((number1 % N) * (number2 % N)) % N);

//        System.out.println("Result stored as BigInteger");
        return res.toString();
    }

/* //outdated code, better version implemented
    public static long expoLists(int num1, int num2) {
        //System.out.print(list1.toString());
        long N = 8717861568456214667l; //prime mod number
        if (num1 == 0)
            return 1;
        if (num2 == 1){

            return num1 % N;
        }

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

 */

    public static String expoLists_1(String num1, String num2) {
        //System.out.print(list1.toString());
        BigInteger N = new BigInteger("5836090530224727663398555102196101238110440949348712473760677766722525717734801063298409008551326821");
//        long N = 8717861568456214667l; //prime mod number
//        BigInteger number1 = BigDecimal.valueOf(num1).toBigInteger();
//        BigInteger number2 = BigDecimal.valueOf(num2).toBigInteger();
        BigInteger number1 = new BigInteger(num1);
        BigInteger number2 = new BigInteger(num2);

//        BigInteger number1 = new BigInteger(temp);
//        BigInteger number2 = new BigInteger(String.valueOf(num2));
        BigInteger result = new BigInteger("0");

        if (number1.equals(BigInteger.valueOf(0)))
            return "1";
        if (number2.equals(BigInteger.valueOf(1))){
            result = number1.mod(N);
            return result.toString();
        }
        BigInteger rand = new BigInteger("2");
        BigInteger temppp = number2.divide(rand);

        String temp_string = number1.toString();
        String temp_string_1= temppp.toString();

        String brrrrrrrrr = expoLists_1(num1, temppp.toString());
        BigInteger temp_0 = new BigInteger(brrrrrrrrr);

//        BigInteger temp_0 = new BigInteger(expoLists_1(temp_string, temp_string_1));

//
//         temp_0 = expoLists_1(number1.toString(), temppp.toString());

//        long num = expoLists(num1, num2 / 2);

        temp_0 = (temp_0.multiply(temp_0));
        temp_0 = temp_0.mod(N);
//        num = (num * num) % N;
//        if exponent is even


        if (number2.doubleValue() % 2 == 0) {
            //System.out.println(num); //for testing purposes
            return temp_0.toString();
//            return num;
        }
        //if exponent is odd
        else {
            //System.out.println(((long) ((num1 % N) * num) % N)); //for testing purposes
            result = number1.mod(N);
            result = result.multiply(temp_0);
            result = result.mod(N);
            return result.toString();
//            return ((long) ((num1 % N) * num) % N);
        }

    }
}// End of class
