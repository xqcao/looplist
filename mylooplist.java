
public class mylooplist {

	public static void main(String[] args) {
		linkedlist alist = new linkedlist();
		Node a = new Node(null, 34);
		Node b = new Node(null, 20);
		Node c = new Node(null, 15);
		Node d = new Node(null, 23);
		Node f = new Node(null, 9);
		Node g = new Node(null, 7);
		//Node h = new Node(null, null);
		alist.ADDnode(a, 34);
		alist.ADDnode(b, 20);
		
		 alist.ADDnode(c, 15);
		 alist.ADDnode(d, 23); 
		 alist.ADDnode(f, 9);
		 alist.ADDnode(g, 7);
		 
		//alist.ADDnode(h, null);
		// System.out.println(alist.head.next.element);
		boolean flag = detectloopLL(alist);
		if ( flag == true ) {
			System.out.println("this linkedlist have  a loop inside");
		} else {
			System.out.println("this linkedlist without  a loop inside");
		}

		//System.out.println(alist.head.next.next.element);

	}

	public static boolean detectloopLL( linkedlist list ) {

		Node first = list.head;
		Node second = list.head;

		while ( first != null ) {//while 成立的条件要尽可能和循环里面相关，否则逻辑不通
			if (second == null || second.next == null) {
				// System.out.println("this linkedlist without  a loop inside");
				return false;
			}
			first = first.next;
			second = second.next.next;
			if ( second == first ) {
				// System.out.println("this linkedlist have  a loop inside");
				return true;
			}
		}
		return false;//if list is null, just return false, 
	}
}

class Node {
	Object element;
	Node next;

	Node(Node next, Object element) {
		this.element = element;
		this.next = next;
	}
}

class linkedlist {
	Node head;
	Node nownd;

	public linkedlist() {
		head = null;
	}

	public void ADD(Object e) {
		if (nownd != null) {
			Node newnode = new Node(null, e);
			nownd.next = newnode;
			newnode.next = head;
			nownd = newnode;
		} else {
			head = new Node(null, e);
			nownd = head;
		}
	}

	public void ADDnode(Node newnode, Object e) {

		if (nownd != null) {
			newnode = new Node(null, e);
			if (newnode.element == null) {
				return;
			} else {
				nownd.next = newnode;
				newnode.next = head; // --------------loop or not
				nownd = newnode;
			}
		} else {
			head = new Node(null, e);
			nownd = head;
		}
	}
}
