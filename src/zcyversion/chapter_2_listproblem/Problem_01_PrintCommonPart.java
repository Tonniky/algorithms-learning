package zcyversion.chapter_2_listproblem;

public class Problem_01_PrintCommonPart {

	public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}

	public static void printCommonPart(Node head1, Node head2) {
		System.out.print("Common Part: ");
		while (head1 != null && head2 != null) {  //如果头不相等，分情况考虑
			if (head1.value < head2.value) {   //如果head2大，那么head1后移
				head1 = head1.next;
			} else if (head1.value > head2.value) {   //如果head1大，那么head2后移
				head2 = head2.next;
			} else {
				System.out.print(head1.value + " ");  //如果head1和head2相等，那么都后移一位，同时打印值
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.println();
	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(6);

		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(5);
		node2.next.next.next = new Node(7);
		node2.next.next.next.next = new Node(8);

		printLinkedList(node1);  //进行一个排列
		printLinkedList(node2);  //同样进行排列
		printCommonPart(node1, node2);

	}

}
