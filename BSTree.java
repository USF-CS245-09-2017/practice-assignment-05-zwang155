public class BSTree {

	private class Node {

		private String data;
		private Node left;
		private Node right;
		private int count;

		private Node(String d) {
			data = d;
			left = null;
			right = null;
			count = 1;
		}
	}

	private Node root;

	public BSTree() {
		root = null;
	}

	public BSTree(String r) {
		root = new Node(r);
	}

	public void insert(String d) {
		if (root == null)
			root = new Node(d);
		else
			insertR(root, d);
	}

	public void insertR(Node n, String d) {
		if (n.data.compareTo(d) > 0) {
			if (n.left == null)
				n.left = new Node(d);
			else
				insertR(n.left, d);
		} else if (n.data.compareTo(d) < 0) {
			if (n.right == null)
				n.right = new Node(d);
			else
				insertR(n.right, d);
		} else
			n.count++;

	}

	public boolean find(String d) {
		return findR(root, d);
	}

	public boolean findR(Node n, String d) {
		if (n == null)
			return false;
		else if (n.data.compareTo(d) > 0)
			return findR(n.left, d);
		else if (n.data.compareTo(d) < 0)
			return findR(n.right, d);
		return true;
	}

	public void delete(String d) {
		root = deleteR(root, d);
	}
	
	private Node replace(Node n) {
		// find the Node to replace n and fix structure
		if (n.right != null) {
			Node temp = n.right;
			if (temp.left == null)
				n = temp;
			else {
				while (temp.left.left != null) {
					temp = temp.left;
				}
				n.data = temp.left.data;
				n.count = temp.left.count;
				temp.left = temp.left.right;
			}
		} else if (n.left != null) {
			Node temp = n.left;
			if (temp.right == null)
				n = temp;
			else {
				while (temp.right.right != null) {
					temp = temp.right;
				}
				n.data = temp.right.data;
				n.count = temp.right.count;
				temp.right = temp.right.left;
			}
		} else
			n = null;
		return n;
	}
	
	public Node deleteR(Node n, String d) {
		if (n == null)
			return null;
		else if (n.data.compareTo(d) > 0)
			n.left = deleteR(n.left, d);
		else if (n.data.compareTo(d) < 0)
			n.right = deleteR(n.right, d);
		else if (n.count > 1)
			n.count--;
		else {
			return replace(n);
		}
		return n;
	}

	public String toStringInOrder() {
		return toStringInOrderR(root).substring(1);
	}

	public String toStringInOrderR(Node n) {
		String s = "";
		if (n.left != null)
			s += toStringInOrderR(n.left);
		s += " " + n.data;
		if (n.right != null)
			s += toStringInOrderR(n.right);
		return s;
	}

	public String toStringPreOrder() {
		return toStringPreOrderR(root).substring(1);
	}

	public String toStringPreOrderR(Node n) {
		String s = " " + n.data;
		if (n.left != null)
			s += toStringPreOrderR(n.left);
		if (n.right != null)
			s += toStringPreOrderR(n.right);
		return s;
	}
}
