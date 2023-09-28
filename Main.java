public class Main {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of SumRootLeaf
        SumRootLeaf sumRootLeaf = new SumRootLeaf();

        // Calculate the sum of root-to-leaf numbers
        int result = sumRootLeaf.sumNumbers(root);

        // Print the result
        System.out.println("Sum of root-to-leaf numbers: " + result);
    }
}
