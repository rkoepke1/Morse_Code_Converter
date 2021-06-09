/**
 * A generic linked binary tree which inherits from the LinkedConverterTreeInterface.
 * 
 * @author Ryan Kopeke
 */

package dataStructure;

import java.util.ArrayList;

import dataElement.TreeNode;
import interfaces.LinkedConverterTreeInterface;

public class MorseCodeTree<T> implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root;
	private String letter;
	
	public MorseCodeTree(){
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}
	
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);
	}
	
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @return the linkedConverterTree with the new node added
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}
	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code.
	 *  A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would 
	 *  be stored as the right child of the left child of the root Algorithm for the recursive method:
	 * 
	 * @param root
	 * @param code
	 * @param letter
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		String newCode = "";
		char[] ch = code.toCharArray();
		if(ch.length == 1) {
			if(ch[0] == '.') {
				root.leftChild = new TreeNode<String>(letter);
			}else if(ch[0] == '-') {
				root.rightChild = new TreeNode<String>(letter);
			}
			return;
		}else {
			if(ch[0] == '.') {
				for(int i = 1; i < ch.length; i ++) {
					newCode += ch[i];
				}
				addNode(root.leftChild, newCode, letter);
			}
			if(ch[0] == '-') {
				for(int i = 1; i < ch.length; i ++) {
					newCode += ch[i];
				}
				addNode(root.rightChild, newCode, letter);
			}
		}
	}
	
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		String letter = fetchNode(root, code);
		return letter;
	}
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String newCode = "";
		char[] ch = code.toCharArray();
		if(ch.length == 1) {
			if(ch[0] == '.') {
				letter = root.leftChild.getData();
			}else if(ch[0] == '-') {
				letter = root.rightChild.getData();
			}
		}else {
			if(ch[0] == '.') {
				for(int i = 1; i < ch.length; i ++) {
					newCode += ch[i];
				}
				fetchNode(root.leftChild, newCode);
			}else if(ch[0] == '-') {
				for(int i = 1; i < ch.length; i ++) {
					newCode += ch[i];
				}
				fetchNode(root.rightChild, newCode);
			}
		}
		return letter;
	}
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * 
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return this;
	}
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * 
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return this;
	}
	
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. The root will have a 
	 * value of "" (empty string) level one: insert(".", "e"); insert("-", "t"); level two: insert("..", "i"); insert(".-", "a"); 
	 * insert("-.", "n"); insert("--", "m"); etc. Look at the tree and the table of codes to letters in the assignment description.
	 */
	@Override
	public void buildTree() {
	       root = new TreeNode<String>("");
	       insert(".", "e");
	       insert("-", "t");
	       insert("..", "i");
	       insert(".-", "a");
	       insert("-.", "n");
	       insert("--", "m");
	       insert("...", "s");
	       insert("..-", "u");
	       insert(".-.", "r");
	       insert(".--", "w");
	       insert("-..", "d");
	       insert("-.-", "k");
	       insert("--.", "g");
	       insert("---", "o");
	       insert("....", "h");
	       insert("...-", "v");
	       insert("..-.", "f");
	       insert(".-..", "l");
	       insert(".--.", "p");
	       insert(".---", "j");
	       insert("-...", "b");
	       insert("-..-", "x");
	       insert("-.-.", "c");
	       insert("-.--", "y");
	       insert("--..", "z");
	       insert("--.-", "q");                  
	}
	
	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly.
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> printTree = new ArrayList<String>();
		LNRoutputTraversal(root, printTree);
		return printTree;
	}
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder).
	 * 
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null) {
			LNRoutputTraversal(root.leftChild, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rightChild, list);
		}
		
	}
}
