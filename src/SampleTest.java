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
        char data1 = (char)4;
        char data2 = (char)3;
        Node test_node_0 = new Node(data1);
        Node test_node_1 = new Node(data2);
        Node test_node_2 = new Node((char)4);

        assertEquals(test_node_2, test_node_0);
        assertFalse(test_node_0.equals(test_node_1));
        assertTrue(test_node_0.equals(test_node_2));

        assertEquals((char)4, test_node_0.getData());
        assertEquals(data1, test_node_0.getData());
        test_node_0.setNext(test_node_1);
        assertEquals(test_node_1, test_node_0.getNext());
        assertEquals(data2, test_node_0.getNext().getData());


    }
    @Test
    public void testLinkedList(){
        Stack test_stack = new Stack(4);
        assertTrue(test_stack.is_empty());
        assertEquals(0, test_stack.size());//testing initial conditions, aka when its empty// havent implemented errors
        //Setting stuff up for comparisons later
        char data_test_0= (char)4;
        char data_test_1 = (char)3;
        char data_test_2 = (char)6;
        Node node_test_0 = new Node(data_test_2);

        test_stack.push(data_test_0);
        test_stack.push(data_test_1);
        test_stack.push(data_test_2);
        assertEquals(test_stack.pop(),node_test_0);
        assertEquals(2, test_stack.size());
        assertEquals(data_test_1, test_stack.peek());



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
