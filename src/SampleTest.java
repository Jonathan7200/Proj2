import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This file contains JUnit tests for some sample arithmetic
 * expressions. This file tests your program "as a whole", by
 * checking its printed output.
 *
 * YOU SHOULD NOT WRITE YOUR OWN TESTS THIS WAY, OR IN THIS FILE.
 * You should test the individual UNITS in your program, i.e., call
 * your add, multiply, and exponentiate methods and test their return
 * values.
 */
public class SampleTest {
    /**
     * The actual standard output stream.
     */
    private PrintStream old;

    /**
     * The streams we're using to capture printed output.
     */
    private ByteArrayOutputStream baos;

    /**
     * Gets called before each test method. Need to do this so that we can
     * capture the printed output from each method.
     */
    @BeforeEach
    public void setUp() {
        this.old = System.out; // Save a reference to the original stdout stream.
        this.baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
    }

    @Test
    public void testNode_0(){
        int data1 = 4;
        int data2 = 3;
        Node test_node_0 = new Node(data1);
        Node test_node_1 = new Node(data2);
        Node test_node_2 = new Node(4);

        assertEquals(test_node_2, test_node_0);
        assertFalse(test_node_0.equals(test_node_1));
        assertTrue(test_node_0.equals(test_node_2));

        assertEquals(4, test_node_0.getData());
        assertEquals(data1, test_node_0.getData());
        test_node_0.setNext(test_node_1);
        assertEquals(test_node_1, test_node_0.getNext());
        assertEquals(data2, test_node_0.getNext().getData());


    }
    @Test
    public void testLinkedList(){
        LinkedList test_list = new LinkedList(4);
        assertTrue(test_list.is_empty());
        assertEquals(0, test_list.size());//testing initial conditions, aka when its empty// havent implemented errors
        //Setting stuff up for comparisons later
        int data_test_0= 4;
        int data_test_1 = 3;
        int data_test_2 = 6;
        Node node_test_0 = new Node(data_test_2);

        test_list.push(data_test_0);
        test_list.push(data_test_1);
        test_list.push(data_test_2);
        assertEquals(test_list.pop(),node_test_0);
        assertEquals(2, test_list.size());
        assertEquals(data_test_1, test_list.peek());



    }

    @Test
    public void testSampleFile() {
        BigNumArithmetic.main(new String[] { "SampleInput.txt" });
        String output = this.baos.toString();
        assertEquals("1 + 2 = 3\n" +
                "2 ^ 4 = 16\n" +
                "3 * 5 = 15\n" +
                "2 ^ 40 = 1099511627776", output);
    }

    /**
     * Gets called after each test method. Need to do this so that we are
     * no longer capturing all printed output and printed stuff appears
     * like normal.
     */
    @AfterEach
    public void tearDown() {
        System.out.flush();
        System.setOut(this.old);
    }
}
