/**
 * The MorseCodeConverter contains a static MorseCodeTree object and constructs (calls the constructor for) the MorseCodeTree.
 * 
 * @author Ryan Koepke
 */
package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dataStructure.MorseCodeTree;

public class MorseCodeConverter {
	
	public static MorseCodeTree<String> tree = new MorseCodeTree<String>();
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’
	 * 
	 * @param codeFile Input for the file that contains the Morse code.
	 * @return A string of decoded Morse code.
	 * @throws FileNotFoundException 
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		String word = "";
		Scanner infile = new Scanner(codeFile);
		while(infile.hasNextLine()) {
			String code = infile.nextLine();
			String[] codeStringParse = code.split("/");
			for(int i = 0; i < codeStringParse.length; i ++) {
				String[] codeWord = codeStringParse[i].split(" ");
				for(int j = 0; j < codeWord.length; j++) {
					if(codeWord[j].length() > 0) {
						word += tree.fetch(codeWord[j]);
					}
				}
				if(i < codeStringParse.length - 1) {
					word += " ";
				}
			}
		}
		return word;
	}
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * 
	 * @param codeFile Input for the string that contains the Morse code.
	 * @return A string of decoded Morse code.
	 */
	public static String convertToEnglish(String code) {
		String word = "";
		String[] codeStringParse = code.split("/");
		for(int i = 0; i < codeStringParse.length; i ++) {
			String[] codeWord = codeStringParse[i].split(" ");
			for(int j = 0; j < codeWord.length; j++) {
				if(codeWord[j].length() > 0) {
					word += tree.fetch(codeWord[j]);
				}
			}
			if(i < codeStringParse.length - 1) {
				word += " ";
			}
		}
		return word;
	}
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList 
	 * method in MorseCodeTree It should return the data in this order:"h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 * Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR 
	 * traversal, the root would come between the right most child of the left tree (j) and the left most child of the 
	 * right tree (b). This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 * 
	 * @return A string that contains the words in the code tree.
	 */
	public static String printTree() {
		String treeChar = "";
		ArrayList<String> codeTree = new ArrayList<String>();
		codeTree = tree.toArrayList();
		for(int i = 0; i < codeTree.size(); i ++) {
			treeChar += codeTree.get(i) + " ";
		}
		return treeChar;
	}
}
