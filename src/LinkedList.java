//useless comment
public class LinkedList {
    private int capacity;
    private Node top;
    private int num_items = 0;
    public LinkedList(int capacity) {
        this.capacity = capacity;
        this.top = null;
        this.num_items = 0;
    }
    public boolean is_empty() {
        if (num_items == 0)return true;
        return false;

    }

    public Node getNext(){
        return top.getNext();
    }

    public boolean is_full() {
        if (capacity == num_items)return true;
        return false;
    }

    public void push(int data) {
        Node node = new Node(data);
        if (this.is_empty() == true){
            this.top = node;
        }
        if (this.is_full() == false) {
            node.setData(data);
            node.setNext(this.top);
            this.top = node;
            this.num_items += 1;
        }
//        raise indexError //fix later, too lazy to look up java how to raise error
    }

    public Node pop() {
        if (this.is_empty() == false) {
//            char top_val = this.top.getData(); //Y No Work??
            Node current = this.top;
            this.top = current.getNext();
            this.num_items -= 1;
            return current;
        }
//        raise indexError; //fix later
        return null;
    }

    public int peek() {
        if (this.is_empty() == false) {
            return this.top.getData();
        }
        return 0;
    }
    public int size() {
        return this.num_items;
    }

    public LinkedList flip(){
        LinkedList result = new LinkedList(this.size());
        while(!this.is_empty()){
            result.push(this.pop().getData());
        }

        return result;
    }

}
