package i.algorithm;

class Node {
	public int data;

	public Node left;
	public Node right;

	public Node(int data) {

		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public void Order(Node root) {
		if (root != null) {
			Order(root.left);
			Order(root.right);
			System.out.print(root.data + " ");
		}
	}

	public void Ordertree() {
		this.Order(this.root);
	}

	public void init(int[] pre, int[] in) {
		this.root = this.initTree(pre, 0, pre.length - 1, in, 0, in.length - 1);

	}

	public Node initTree(int[] pre, int low, int high, int[] in, int low2, int high2) {
		if (low > high || low2 > high2) {
			return null;
		}
		int rootdata = pre[low];
		Node head = new Node(rootdata);
		int index = find(in, rootdata, low2, high2);
		Node left = initTree(pre, low + 1, low + index - low2, in, low2, index - 1);
		Node right = initTree(pre, low + index - low2 + 1, high, in, index + 1, high2);
		head.left = left;
		head.right = right;
		return head;
	}

	public int find(int[] a, int x, int start, int end) {
		for (int i = start; i <= end; i++) {
			if ( a[i] ==x) {
				return i;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 8, 9, 5, 10, 3, 6, 7 };
		int[] in = { 8, 4, 9, 2, 10, 5, 1, 6, 3, 7 };
		Tree tree = new Tree();
		tree.init(pre, in);
		System.out.println("后续遍历为");
		tree.Ordertree();
	}
}
