public class LinkedStack extends Stack{
    int capacity;
    Node top = null;
    int num_items = 0; //this whole class may be pointless?

    public LinkedStack(int capacity, Node top) {
        super(capacity, top);
    }
}
