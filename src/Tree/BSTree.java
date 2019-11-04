package Tree;

import org.omg.CORBA.PRIVATE_MEMBER;

class Node<T extends Comparable<T>> {
	int key;
	T val;
	Node<T> left;
	Node<T> right;

	public Node() {

	}

	public Node(int key, T val) {
		this.key = key;
		this.val = val;
	}
}

public class BSTree<T extends Comparable<T>> {
	private Node<T> root = null;

	private void insert(int key, T val) {
		if (root == null) {
			root = new Node<T>(key, val);
			return;
		}
		Node newNode = new Node(key, val);
		Node cur = root;
		Node parent = root;

		while (true) {// 直到找到该插入的位置
			parent = cur;
			if (key < cur.key) { // 如果小于当前节点的值，往左子树查找
				cur = cur.left;
				if (cur == null) {
					parent.left = newNode;
					return;
				}
			} else { // 如果大于当前节点的值，往右子树查找
				cur = cur.right;
				if (cur == null) {
					parent.right = newNode;
					return;
				}

			}
		}

	}

	private boolean delete(int key) {
		Node cur = root;
		Node parent = root;
		while (cur.key != key) {
			parent = cur;
			if (cur.key < key) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}
			if (cur == null) {
				return false;
			}
		}
		if (cur.left == null && cur.right == null) {// 叶子节点
			if (cur == root) {
				root = null;
			} else if (parent.left == cur) {
				parent.left = null;
			} else {
				parent.right = null;
			}

		} else if (cur.left == null && cur.right != null) {// 左节点空,右节点不空
			if (cur == root) {
				root = cur.right;
			} else if (parent.left == cur) {
				parent.left = cur.right;
			} else {
				parent.right = cur.right;
			}
		} else if (cur.left != null && cur.right == null) {// 右节点空,左节点不空
			if (cur == root) {
				root = cur.left;
			} else if (parent.left == cur) {
				parent.left = cur.left;
			} else {
				parent.right = cur.left;
			}
		} else {
			Node<T> n = find(cur);
			if (cur == root) {
				root = n;
			} else if (parent.left == cur) {
				parent.left = n;
			} else {
				parent.right = n;
			}n.left=cur.left;
		}
		
		return true;

	}

	private Node<T> find(Node cur) {
		Node<T> nparent = cur;
		Node<T> n = cur;
		Node<T> ncur = cur.right;
		while (ncur != null) {
			nparent=n;
			n=ncur;
			ncur=ncur.left;
		}
		
		return n;

	}

	private void scanPreOrder(Node<T> parentNode) {
		if (parentNode == null) {
			return;
		}
		scanPreOrder(parentNode.left);
		System.out.print(parentNode.key + ":" + parentNode.val + "  ");
		scanPreOrder(parentNode.right);
	}

	public static void main(String[] args) {
		BSTree<String> bsTree = new BSTree<String>();
		bsTree.insert(9, "jj");
		bsTree.insert(7, "jqj");
		bsTree.insert(88, "jaqj");
		bsTree.insert(18, "jaj");
		bsTree.insert(118, "jaj");
		bsTree.delete(88);
		bsTree.scanPreOrder(bsTree.root);
	}

}
