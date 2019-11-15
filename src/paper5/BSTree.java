package paper5;

public class BSTree {
	private TreeNode root;

	/**
	 * Constructor for an empty binary search tree.
	 */
	public BSTree() {
	}

	/**
	 * Constructor for a binary search tree that contains the given element.
	 * 
	 * @param value the value to be inserted.
	 */
	public BSTree(int value) {
		this.root = new BSTreeNode(value);
	}

	/**
	 * Inserts a given value in the binary search tree. (3 Punkte)
	 * 
	 * @param value the value to be inserted.
	 */
	public void insert(int value) {
		// TODO: Implement the algorithm here.
	}

	// TODO: Implement additional methods here (if needed).

	/**
	 * Determines whether or not a given value is within the binary search tree. (2
	 * Punkte)
	 * 
	 * @param value the value to search.
	 * @return the tree node containing the search value, if any, or null otherwise.
	 */
	public TreeNode search(int value) {
		// TODO: Implement the algorithm here.
		return null;
	}

	// TODO: Implement additional methods here (if needed).

	/**
	 * Returns the tree node containing the maximum element, or null if this tree is
	 * empty. (1 Punkt)
	 * 
	 * @return the tree node containing the maximum
	 */
	public TreeNode maximum() {
		// TODO: Implement the algorithm here.
		return null;
	}

	// TODO: Implement additional methods here (if needed).

	/**
	 * Returns the tree node containing the minimum element, or null if this tree is
	 * empty. (1 Punkt)
	 * 
	 * @return the tree node containing the minimum
	 */
	public TreeNode minimum() {
		// TODO: Implement the algorithm here.
		return null;
	}

	// TODO: Implement additional methods here (if needed).

	/**
	 * Deletes and returns a values from the binary search tree. (5 Punkte)
	 * 
	 * @return the value to be returned.
	 */
	public TreeNode delete(int value) {
		// TODO: Implement the algorithm here.
		return null;
	}

	// TODO: Implement additional methods here (if needed).

	/**
	 * Prints the elements of this binary search tree in an inorder traversal.
	 */
	public void inorderTreeTraversal() {
		this.inorderTreeTraversal(this.root);
		System.out.println();
	}

	private void inorderTreeTraversal(TreeNode x) {
		if (x != null) {
			this.inorderTreeTraversal(x.getLeftChild());
			System.out.print(x.getValue() + " ");
			this.inorderTreeTraversal(x.getRightChild());
		}
	}
}