package paper5;

public class BSTreeNode implements TreeNode {

	// class variables
	private int value;
	private TreeNode parent, leftChild, rightChild;

	public BSTreeNode(int value) {
		this.value = value;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public TreeNode getLeftChild() {
		return leftChild;
	}

	@Override
	public TreeNode getRightChild() {
		return rightChild;
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public void setLeftChild(TreeNode v) {
		this.leftChild = v;
	}

	@Override
	public void setRightChild(TreeNode v) {
		this.rightChild = v;
	}

	@Override
	public void setParentNode(TreeNode v) {
		this.parent = v;
	}
}