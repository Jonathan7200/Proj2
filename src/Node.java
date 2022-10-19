public class Node {
    private Node next;
    private char data;

    public char getData() {
        return data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setData(char data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(char data) {
        this.data = data;
        this.next = null;
    }

    public Node(char data, Node next){
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
