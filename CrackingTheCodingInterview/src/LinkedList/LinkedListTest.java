package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LinkedListTest {
	
	@Test
	public void linkedListCreation() {
		LinkedList randomValue = new LinkedList("Harraow");
		
		assertEquals("Harraow", randomValue.getHead().getValue());
		
	}
	
	@Test
	public void linkedListPushFront() {
		LinkedList randomValue = new LinkedList("Harraow");
		
		randomValue.pushFront("Second");
		
		assertEquals("Second", randomValue.getHead().getValue());
		assertEquals("Harraow", randomValue.getHead().getNext().getValue());
		
	}
	
	

}
