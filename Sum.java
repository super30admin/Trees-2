/*the time complexity of this implementation is O(n)*/
import javax.swing.tree.TreeNode;

class Sum {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        int leftSum = sumNumbersHelper(node.left, currentSum);
        int rightSum = sumNumbersHelper(node.right, currentSum);

        return leftSum + rightSum;
    }
    public static void main(String[] args) {
        // Construct a binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // Create a new instance of the Solution class
        Sum solution = new Sum();

        // Call the sumNumbers method to get the sum of the numbers represented by the root-to-leaf paths
        int sum = solution.sumNumbers(root);

        // Print the result
        System.out.println("Sum of numbers represented by root-to-leaf paths: " + sum);
    }

}
