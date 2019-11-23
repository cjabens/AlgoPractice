package LinkedList;
import java.lang.Exception;

public class LinkedList {
    private Node head = null;

    LinkedList(String str) {
        head = new Node(str, null);
    }

    public void pushFront(String str) {
        head = new Node(str, head);
    }

    public Node getHead() {
        return head;
    }

    public Node appendItem(String str) {
    	return head;
	}

	public Node removeItem(int number){
		return head;
	}
}
