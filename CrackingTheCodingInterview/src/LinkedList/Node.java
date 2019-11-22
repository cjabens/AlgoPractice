package LinkedList;

public class Node {
    private String value;
    private Node next;

    Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }
    
    public Node getNext() {
    	return this.next;
    }
    
    public String getValue() {
    	return this.value;
    }
};
