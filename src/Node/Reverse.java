package Node;
public class Reverse {
	public static void main(String[] args) {
		Node2 head = new Node2(0);
		Node2 node1 = new Node2(1);
		Node2 node2 = new Node2(2);
		Node2 node3 = new Node2(3);
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
 
		// 打印反转前的链表
		Node2 h = head;
		while (null != h) {
			System.out.print(h.getData() + " ");
			h = h.getNext();
		}
		// 调用反转方法
		head = Reverse1(head);
 
		System.out.println("\n**************************");
		// 打印反转后的结果
		while (null != head) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
	}
 
	/**
	 * 递归，在反转当前节点之前先反转后续节点
	 */
	public static Node2 Reverse1(Node2 head) {
		// head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
		if (head == null || head.getNext() == null) {
			return head;// 若为空链或者当前结点在尾结点，则直接还回
		}
		Node2 reHead = Reverse1(head.getNext());// 先反转后续节点head.getNext()
		head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
		head.setNext(null);// 前一结点的指针域令为null;
		return reHead;// 反转后新链表的头结点
	}
}
 
	class Node2 {
		private int Data;// 数据域
		private Node2 Next;// 指针域
 
		public Node2(int Data) {
			// super();
			this.Data = Data;
		}
 
		public int getData() {
			return Data;
		}
 
		public void setData(int Data) {
			this.Data = Data;
		}
 
		public Node2 getNext() {
			return Next;
		}
 
		public void setNext(Node2 Next) {
			this.Next = Next;
		}
	}

