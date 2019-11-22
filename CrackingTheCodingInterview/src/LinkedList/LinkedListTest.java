package LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
	public void linkedListAppend() {
		LinkedList randomValue = new LinkedList("first");
		randomValue.appendItem("second");
		randomValue.appendItem("third");

		assertEquals(
				"first",
				randomValue.getHead() // first
						.getValue()
		);

		assertEquals(
				"second",
				randomValue.getHead() // first
					.getNext() // second
					.getValue()
		);

		assertEquals(
				"third",
				randomValue.getHead() // first
						.getNext() // second
						.getNext() // third
						.getValue()
		);
	}

	@Test
	public void linkedListRemove() {
		LinkedList randomValue = new LinkedList("first");
		randomValue.appendItem("second");
		randomValue.appendItem("third");

		randomValue.removeItem(1);

		assertEquals(
				null,
				randomValue.getHead() // first
						.getNext() // second
						.getNext()
						.getValue()
		);
	}

}
