
public class BSTree {
	private Node root;
	
	public BSTree() {
		root = null;
	}
	
	public BSTree(String r){
		root = new Node(r);
	}
	
	public void insert(String d) {
		if (root == null)
			root = new Node(d);
		else
			insertR(root, d);
	}
	public void insertR(Node n, String d) {
		if (n.get().compareTo(d) > 0) {
			if (n.left() == null)
				n.setLeft(new Node(d));
			else
				insertR(n.left(), d);
		}
		else if (n.get().compareTo(d) < 0) {
			if (n.right() == null)
				n.setRight(new Node(d));
			else
				insertR(n.right(), d);
		}
		else
			n.add();
			
	}
	
	public boolean find(String d) {
		return findR(root, d);
	}
	public boolean findR(Node n, String d) {
		if (n == null)
			return false;
		else if (n.get().compareTo(d) > 0)
			return findR(n.left(), d);
		else if (n.get().compareTo(d) < 0)
			return findR(n.right(), d);
		return true;
	}
	
	public void delete(String d) {
		deleteR(root, d);
	}
	public void deleteR(Node n, String d) {
		if (n.get().compareTo(d) > 0)
			if (n.left() == null)
				return;
			else if (n.left().left() == null && n.left().right() == null && n.left().get().equals(d)) {
				if (n.left().getCount() > 1)
					n.left().remove();
				else
					n.setLeft(null);
			}
			else
				deleteR(n.left(), d);
		else if (n.get().compareTo(d) < 0)
			if (n.right() == null)
				return;
			else if (n.right().left() == null && n.right().right() == null && n.right().get().equals(d)) {
				if (n.right().getCount() > 1)
					n.right().remove();
				else
					n.setRight(null);
			}
			else
				deleteR(n.right(), d);
		else if (n.getCount() > 1)
			n.remove();
		else {
			if (n.right() != null) {
				Node temp = n.right();
				if (temp.left() == null) {
					n.set(temp.get());
					n.setCount(temp.getCount());
					n.setRight(temp.right());
				} else {
					while (temp.left().left() != null) {
						temp = temp.left();
					}
					n.set(temp.left().get());
					n.setCount(temp.left().getCount());
					temp.setLeft(temp.left().right());
				}
			} else if (n.left() != null) {
				Node temp = n.left();
				if (temp.right() == null) {
					n.set(temp.get());
					n.setCount(temp.getCount());
					n.setLeft(temp.left());
				} else {
					while (temp.right().right() != null) {
						temp = temp.right();
					}
					n.set(temp.right().get());
					n.setCount(temp.right().getCount());
					temp.setRight(temp.right().left());
				}
			} else
				root = null;
		}
	}
	
	public String toStringInOrder() {
		return toStringInOrderR(root).substring(1);
	}
	public String toStringInOrderR(Node n) {
		String s = "";
		if (n.left() != null)
			s += toStringInOrderR(n.left());
		s += " " + n.get();
		if (n.right() != null)
			s += toStringInOrderR(n.right());
		return s;
	}
	
	public String toStringPreOrder() {
		return toStringPreOrderR(root).substring(1);
	}
	public String toStringPreOrderR(Node n) {
		String s = " " + n.get();
		if (n.left() != null)
			s += toStringPreOrderR(n.left());
		if (n.right() != null)
			s += toStringPreOrderR(n.right());
		return s;
	}
	
}
