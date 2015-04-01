package misc;

public class Node {
	public int data;
	public Node next;
	//private static Node instance = null;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	public void displayLink(){
		System.out.println(" "+data);
	}

	
}
