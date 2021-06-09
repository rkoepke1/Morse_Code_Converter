/**
 * This generic class is used in the MorseCodeTree classes.  The class consists of a reference to the data and a reference to the
 * left and right child.
 * 
 * @author Ryan Koepke
 */
package dataElement;

public class TreeNode<T> {
	private T data;
	public TreeNode<T> rightChild;
	public TreeNode<T> leftChild;
	
	/**
	 * Constructor that initializes the left and right nodes of the binary tree.
	 * 
	 * @param data The data for each node.
	 */
	public TreeNode(T data) {
		this.data = data;
		rightChild = null;
		leftChild = null;
	}
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode.
	 * 
	 * @param node The data to be stored in the TreeNode
	 */
	public TreeNode(TreeNode<T> node) {
		this.rightChild = node.rightChild;
		this.leftChild = node.leftChild;
		this.data = node.getData();
	}
	/**
	 * Return the data within this TreeNode
	 * 
	 * @return The data within the TreeNode
	 */
	public T getData() {
		return data;
	}

}
