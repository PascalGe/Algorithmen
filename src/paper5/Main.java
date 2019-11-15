package paper5;

public class Main {

	public static void main(String[] args) {
		// Initialize a binary search tree.
		BSTree tree = new BSTree();

		// Add 100 random values between 0 and 1000 in the binary search tree
		java.util.Random random = new java.util.Random();
		for (int i = 0; i < 100; i++) {
			tree.insert(random.nextInt(1000));
		}

		System.out.println(
				"If you see the next output sorted, then your implementation of insert operation should be correct.");
		tree.inorderTreeTraversal();

		System.out.println("Maximum: " + tree.maximum().getValue());
		System.out.println("Mimimum: " + tree.minimum().getValue());

		// Add 100 and 200 in the binary search tree
		tree.insert(100);
		tree.insert(200);

		// Print the tree again.
		System.out.println();
		System.out.println("Sorted elements of the tree after inserting 100 and 200.");
		tree.inorderTreeTraversal();

		// Search for 100 and 150 in the tree; 150 might exist in the tree or not, 100
		// should exist and 2000 should not exist.
		System.out.println(tree.search(100) != null ? "100 exists in the tree." : "100 does not exist in the tree.");
		System.out.println(tree.search(150) != null ? "150 exists in the tree." : "150 does not exist in the tree.");
		System.out.println(tree.search(2000) != null ? "2000 exists in the tree." : "2000 does not exist in the tree.");

		// Delete 10, 100 and 150 from the tree; 10 and 150 might not exist in the tree,
		// but 100 exists.
		tree.delete(10);
		tree.delete(100);
		tree.delete(150);

		// Print the tree again.
		System.out.println();
		System.out.println(
				"If you see the next output sorted, then your implementation of delete operation should be correct.");
		tree.inorderTreeTraversal();
	}
}