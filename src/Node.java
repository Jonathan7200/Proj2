public class Node {
    private Node next;
    private long data;

    public long getData() {
        return data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setData(long data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(long data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    @Override
    public boolean equals(Object o){
        if (o == null)return false;
        if (!(o instanceof Node))return false;
        Node node = (Node) o;
        if(this.data == node.getData())return true;
        return false;
    }


}
