package linkedList;

public class CreatingLinkedListofSizeN {

	public static void main(String[] args) {
		// System.out.println(create list(5));
	}

	public class Node {
		int val;			//created one global variable
		Node next;

		Node(int x) {
			val = x;
			next = null;
		}
	}

	Node createlist(int N) {
		Node h = new Node(1);					//created head node
		Node l = h;
		for (int i = 2; i <= N; i++) {
			l.next = new Node(i);			//l.next will contain address of new Node
			l = l.next;						//l will contain the address of currently formed Node 
		}
		return h;					//returning the head Node
	}
	
//	Node t=h;
//	while(t!=null) {
//		System.out.println("curr Node "+t+" val "+t.val+" next Node "+t.next);
//	}

}
