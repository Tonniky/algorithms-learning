package chapter_2_listproblem;

public class Problem_03_RemoveNodeByRatio {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node removeMidNode(Node head) {
		if (head == null || head.next == null) {  //只有一个值的时候
			return head;
		}
		if (head.next.next == null) {   //只有2个值
			return head.next;
		}
		Node pre = head;    //
		Node cur = head.next.next;
		while (cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;  //当其中的一个走到末尾，pre走到中间
		}
		pre.next = pre.next.next;  //跳过要删除的该点
		return head;
	}

	public static Node removeByRatio(Node head, int a, int b) {
		if (a < 1 || a > b) {  //排除特殊情况
			return head;
		}
		int n = 0;
		Node cur = head;
		while (cur != null) {   //使用的值是
			n++;        //统计长度
			cur = cur.next;
		}
		n = (int) Math.ceil(((double) (a * n)) / (double) b);  //计算出值
		if (n == 1) {
			head = head.next;     //使用的是
		}
		if (n > 1) {
			cur = head;			   //
			while (--n != 1) {     //n的值一直减少
				cur = cur.next;
			}
			cur.next = cur.next.next;  //移除要删除的值
		}
		return head;
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		printLinkedList(head);
		head = removeMidNode(head);
		printLinkedList(head);
		head = removeByRatio(head, 2, 5);
		printLinkedList(head);
		head = removeByRatio(head, 1, 3);
		printLinkedList(head);
	}

}
