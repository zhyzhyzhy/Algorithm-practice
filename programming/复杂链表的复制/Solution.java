/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/09/14 - 20:43:24
*/
class Node {
	Node next;
	Node subNode;
	int val;
	public Node(int val) {
		this.val = val;
	}
}
public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		solution.printLinkedList(head);
		solution.copyComplicatedLinkedList(head);
		solution.printLinkedList(head);
	}
	public Node copyComplicatedLinkedList(Node head) {
		if (head == null) {
			return null;
		}
		Node p = head;
		while (p != null) {
			Node node = new Node(p.val);
			node.next = p.next;
			p.next = node;
			p = p.next.next;
		}

		p = head;
		while (p != null) {
			if (p.subNode != null) {
				p.next.subNode = p.subNode.next;
			}
			p = p.next.next;
		}

		Node clonedHead = head.next;
		Node q = clonedHead;
		p = clonedHead.next;
		head.next = p;
		while (p != null) {
			q.next = p.next;
			q = q.next;
			p.next = p.next.next;
			p = p.next;
		}
		return clonedHead;
	}
	public void printLinkedList(Node root) {
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
		System.out.println();
	}

}

