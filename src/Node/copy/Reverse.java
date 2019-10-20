package Node.copy;
public class Reverse {
	public static void main(String[] args) {
		Node2 head = new Node2(0);
		Node2 node1 = new Node2(1);
		Node2 node2 = new Node2(2);
		Node2 node3 = new Node2(3);
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
 
		// ��ӡ��תǰ������
		Node2 h = head;
		while (null != h) {
			System.out.print(h.getData() + " ");
			h = h.getNext();
		}
		// ���÷�ת����
		head = Reverse1(head);
 
		System.out.println("\n**************************");
		// ��ӡ��ת��Ľ��
		while (null != head) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
	}
 
	/**
	 * �ݹ飬�ڷ�ת��ǰ�ڵ�֮ǰ�ȷ�ת�����ڵ�
	 */
	public static Node2 Reverse1(Node2 head) {
		// head������ǰһ��㣬head.getNext()�ǵ�ǰ��㣬reHead�Ƿ�ת���������ͷ���
		if (head == null || head.getNext() == null) {
			return head;// ��Ϊ�������ߵ�ǰ�����β��㣬��ֱ�ӻ���
		}
		Node2 reHead = Reverse1(head.getNext());// �ȷ�ת�����ڵ�head.getNext()
		head.getNext().setNext(head);// ����ǰ����ָ����ָ��ǰһ���
		head.setNext(null);// ǰһ����ָ������Ϊnull;
		return reHead;// ��ת���������ͷ���
	}
}
 
	class Node2 {
		private int Data;// ������
		private Node2 Next;// ָ����
 
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

