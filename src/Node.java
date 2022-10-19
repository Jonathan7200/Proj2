public class Node {
    private Node next;
    private int data;

    String math_symbol;

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
  //   Node(Node next, int data);

    // Node(Node next, String math_symbol);





   // class Node:
  //  def __init__(self, data):
   // self.data = data
   // self.next = None
}
