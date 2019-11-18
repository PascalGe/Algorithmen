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
		if (this.root == null) {
			return;
		}

		TreeNode current = this.root;

		while ((value > current.getValue() && current.getRightChild() != null)
				|| (value <= current.getValue() && current.getLeftChild() != null)) {
			//
			if (value > current.getValue()) {
				// insert right
				current = current.getRightChild();
			} else {
				// insert left
				current = current.getLeftChild();
			}
		}

		if (value > current.getValue()) {
			// insert right
			current.setRightChild(new BSTreeNode(value));
			current.getRightChild().setParentNode(current);
		} else {
			// insert left
			current.setLeftChild(new BSTreeNode(value));
			current.getLeftChild().setParentNode(current);
		}
	}

	/**
	 * Determines whether or not a given value is within the binary search tree. (2
	 * Punkte)
	 * 
	 * @param value the value to search.
	 * @return the tree node containing the search value, if any, or null otherwise.
	 */
	public TreeNode search(int value) {
		TreeNode current = this.root;
		while (current != null && current.getValue() != value) {
			if (value > current.getValue()) {
				// search right
				current = current.getRightChild();
			} else {
				// search left
				current.getLeftChild();
			}
		}
		return current;
	}

	/**
	 * Returns the tree node containing the maximum element, or null if this tree is
	 * empty. (1 Punkt)
	 * 
	 * @return the tree node containing the maximum
	 */
	public TreeNode maximum() {
		if (this.root == null) {
			return null;
		}
		return getMaximum(root);
	}

	// additional methods here (if needed).
	private TreeNode getMaximum(TreeNode root) {
		TreeNode current = root;
		while (current.getRightChild() != null) {
			current = current.getRightChild();
		}
		return current;
	}

	/**
	 * Returns the tree node containing the minimum element, or null if this tree is
	 * empty. (1 Punkt)
	 * 
	 * @return the tree node containing the minimum
	 */
	public TreeNode minimum() {
		if (this.root == null) {
			return null;
		}

		TreeNode current = this.root;
		while (current.getLeftChild() != null) {
			current = current.getLeftChild();
		}
		return current;
	}

	/**
	 * Deletes and returns a values from the binary search tree. (5 Punkte)
	 * 
	 * @return the value to be returned.
	 */
	public TreeNode delete(int value) {
		TreeNode node = search(value);
		if (node == null) {
			return null;
		}
		TreeNode parent = node.getParent();

		switch (getNumberOfChilds(node)) {
		case 0:
			if (this == parent.getLeftChild()) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
			break;
		case 1:
			if (this == parent.getLeftChild()) {
				parent.setLeftChild(node.getLeftChild() == null ? node.getRightChild() : node.getLeftChild());
			} else {
				parent.setRightChild(node.getLeftChild() == null ? node.getRightChild() : node.getLeftChild());
			}
			break;
		case 2:
			TreeNode v = getMaximum(node.getLeftChild());
			// delete v in tree
			v.getParent().setRightChild(null);
			// set v in tree
			v.setLeftChild(node.getLeftChild());
			if (node.getParent().getRightChild() == node) {
				node.getParent().setRightChild(v);
			} else {
				node.getParent().setLeftChild(v);
			}
			break;
		}
		return node;
	}

	// additional methods here (if needed).
	private int getNumberOfChilds(TreeNode node) {
		int number = 0;
		if (node.getLeftChild() != null) {
			number++;
		}
		if (node.getRightChild() != null) {
			number++;
		}
		return number;
	}

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