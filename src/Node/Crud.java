package Node;

import java.awt.font.TextMeasurer;
import java.util.LinkedList;

import javax.swing.text.StyledEditorKit.BoldAction;

class Node {
	Node nextNode = null;
	int data;

	public Node(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
}

public class Crud {
	Node head = null;

	public void add(int data) {// 尾部插入一个元素
		
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node temp = head;
	while (temp.nextNode != null) {
			temp = temp.nextNode;
		}
		temp.nextNode =new Node(data);;
	}

	public Boolean delete(int index) {// 删除指定位置的元素
		if (index < 0 || index > length()) {
			return false;

		}
		if (index == 1) {
			head = head.nextNode;
			return true;

		}
		int i = 2;
		Node preNode = head;
		Node tempNode = preNode.nextNode;
		while (tempNode != null) {
			if (index == i) {
				preNode.nextNode = tempNode.nextNode;
				return true;
			}
			preNode = preNode.nextNode;
			i++;
		}
		return true;
	}

	public boolean delete2(int data) {
		if (data == head.data) {
			head = head.nextNode;
			return true;
		}

		Node preNode = head;
		Node tempNode = preNode.nextNode;
		while (tempNode != null) {
			if (data == tempNode.data) {
				preNode.nextNode = tempNode.nextNode;
				return true;
			}
			preNode = preNode.nextNode;

		}
		return true;
	}

	public int length() {
		int length = 0;
		Node tempNode = head;
		while (tempNode != null) {
			length++;
			tempNode = tempNode.nextNode;
		}
		return length;
	}

	public void print() {
		Node tempNode = head;
		while (tempNode != null) {
			System.out.println(tempNode.data + " ");
			tempNode = tempNode.nextNode;
		}
	}

	public void Order() {
		Node tempNode = head;
		Node next = null;
		int a = 0;
		while (tempNode.nextNode != null) {
			next = tempNode.nextNode;
			while (next != null) {
				if (tempNode.data > next.data) {
					a = tempNode.data;
					tempNode.data = next.data;
					next.data = a;
				}
				next = next.nextNode;
			}
			tempNode = tempNode.nextNode;
		}
	}
	public void Reverselist(Node head) {
		Node tempNode=head;
		Node reverseNode=head;
		Node preNode=null;
		while(tempNode!=null)
		{
			Node next=tempNode.nextNode;
			if (next==null) {
				reverseNode=preNode;
			}
			tempNode.nextNode=preNode;
			preNode=tempNode;
			tempNode=next;
		}
		this.head=reverseNode;
		
		
	}
	public void printrev(Node headNode) {
		if (headNode!=null) {
			printrev(headNode.nextNode);
			System.out.println(headNode.data);
		}
	}
	public static void main(String[] args) {
		Crud list = new Crud();
		
		list.add(5);
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(8);
		
		// list.delete2(3);
		
		list.print();
		System.out.println(list.length());
	}
}
