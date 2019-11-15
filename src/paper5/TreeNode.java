package paper5;

public interface TreeNode {

	/**
	 * Returns the value of this given tree node.
	 * 
	 * @return an integer value.
	 */
	public int getValue();

	/**
	 * Returns the left child of this tree node; null if there is no left child.
	 * 
	 * @return the left child.
	 */
	public TreeNode getLeftChild();

	/**
	 * Returns the right child of this tree node; null if there is no right child.
	 * 
	 * @return the right child.
	 */
	public TreeNode getRightChild();

	/**
	 * Returns the parent node of this tree node; null if this is the root.
	 * 
	 * @return the parent node.
	 */
	public TreeNode getParent();

	/**
	 * Sets the value of this node.
	 * 
	 * @param value the given value.
	 */
	public void setValue(int value);

	/**
	 * Sets the left child of this tree node.
	 * 
	 * @param v the left child.
	 */
	public void setLeftChild(TreeNode v);

	/**
	 * Sets the right child of this tree node.
	 * 
	 * @param v the right child.
	 */
	public void setRightChild(TreeNode v);

	/**
	 * Sets the parent node of this tree node.
	 * 
	 * @param v the parent node.
	 */
	public void setParentNode(TreeNode v);

}