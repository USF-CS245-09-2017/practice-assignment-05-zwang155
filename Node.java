
public class Node {
	private String data;
	private Node left;
	private Node right;
	private int count;
	
	public Node() {
		data = null;
		left = null;
		right = null;
		count = 0;
	}
	public Node(String d) {
		data = d;
		left = null;
		right = null;
		count = 1;
	}
	
	public Node left() {
		return left;
	}
	
	public Node right() {
		return right;
	}
	
	public String get() {
		return data;
	}
	
	public void set(String d) {
		data = d;
		count = 1;
	}
	
	public void setLeft(Node n) {
		left = n;
	}
	
	public void setRight(Node n) {
		right = n;
	}
	
	public void add() {
		count ++;
	}
	
	public void remove() {
		count --;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int c) {
		count = c;
	}
	
	
}
