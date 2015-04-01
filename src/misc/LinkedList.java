package misc;

public class LinkedList {

	private Node first;

	public LinkedList() {
		this.first = null;
	}

	public void create(int data) {
		Node node = new Node(data);
		if (first != null) {
			node.next = first;
		}
		first = node;

	}

	public void displayLinkedList() {
		for (Node current = first; current != null; current = current.next) {

		}

	}

}
