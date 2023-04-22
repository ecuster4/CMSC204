import java.util.ArrayList;
/**
 * 
 * @author Andy Nguyen
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * @return reference to root
	 */
	@Override
	public TreeNode<java.lang.String> getRoot(){
		
		return root;
	}
	
	/**
	 * @param newNode - a newNode that will be the root of MorseCodeTree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		root = new TreeNode<String>(newNode);
	}
	
	/**
	 * @param code - the code for the new node to be added, example ".-."

	 */
	@Override
	public void insert(String code, String letter) {
		// TODO Auto-generated method stub
		addNode(root, code, letter);
	}
	
	/**
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub
		if (code.length() == 1) {
			if  (code.equals(".")) {
				root.left = new TreeNode<String>(letter);
				
			}
			else if (code.equals ("-")){
				root.right= new TreeNode<String>(letter);
			}
		}
		else if (code.length() !=1) {
			
			if (code.charAt(0)=='.') {
				addNode(root.left, code.substring(1),letter);
			}
			
			else if (code.charAt(0) =='-') {
				addNode(root.right, code.substring(1),letter);
			}
			
			
		}
	}
	/**
	 * @param code - the code that describes the traversals to retrieve the string (letter)
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		String fetched = fetchNode(root, code);
		return fetched;
		
	}
	/**
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string (letter) corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		if (code.length() == 1) {
			if (code.equals(".")) {
				return root.left.getData();
			}
			else if (code.equals("-")) {
				return root.right.getData();
			}
		} else if (code.length() != 1) {
			if (code.charAt(0) == '-') {
				return fetchNode(root.right, code.substring(1));
			}
			else if (code.charAt(0) == '.') {
				return fetchNode(root.left, code.substring(1));
			}
		}
		return null;
	}
	
	
	/**
	 * @param data - data of node to be deleted
	 * @return reference to the current tree
	 * @throw UnsupportedOperationException
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**
	 * @return reference to the current tree
	 * @throw UnsupportedOperationException
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 */
	@Override
	public void buildTree() {
		root = (new TreeNode<String>(""));
		
		
		
		insert(".", "e"); insert("-", "t");
		
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		insert("---", "o");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert("-..", "d");
		insert(".--", "w");
		insert("--.", "g");
		insert("-.-", "k");
		
		insert("....", "h");
		insert(".-..", "l");
		insert("..-.", "f");
		insert("...-", "v");
		insert("-...", "b");
		insert(".--.", "p");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("--..", "z");
		insert(".---", "j");
		insert("-.--", "y");
		insert("--.-", "q");
	}
	
	/**
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList(){
		ArrayList<String> listed = new ArrayList<String>();
		LNRoutputTraversal (root, listed);
		return listed;
	}
	
	/**
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		
		else 
		{
			
			LNRoutputTraversal(root.left, list);		
			list.add(root.getData());		
			LNRoutputTraversal(root.right, list);
		}
	}
}
