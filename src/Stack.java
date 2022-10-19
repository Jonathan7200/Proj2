import java.util.Map;
//useless comment
public class Stack {
    private int capacity;
    private Node top = null;
    private int num_items = 0;
    public Stack(int capacity, Node top) {
        this.capacity = capacity;
        this.top = top;
    }
    public boolean is_empty() {
        if (num_items == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean is_full() {
        if (capacity == num_items) {return true;}
        return false;
    }

    public void push(int item) {
        Node n = new Node(item);
        if (this.is_full() == false) {
            n.setData(item);
            n.setNext(this.top);
            this.top = n;
            this.num_items += 1;
        }
        raise indexError //fix later, too lazy to look up java how to raise error
    }

    public Node pop() {
        if (this.is_empty() == false) {
            top = this.top.getData(); //Y No Work??
            this.top = this.top.getNext();
            this.num_items -= 1;
            return top;
        }
        raise indexError; //fix later
        return top;
    }

    public int peek() {
        if (this.is_empty() == false) {
            return this.top.getData();
        }
        raise IndexError //fix later
        return 0;
    }
    public int size() {
        return this.num_items;
    }

}
