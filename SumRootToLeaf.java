// The idea is to do a preorder traversal, and at each interval increment the sum, and when you reach the leaf node, increment the sum to the overall sum of the tree

// Time Complexity : O(N)
// Space Complexity : O(H), where H is the height of the tree and this space is to keep the recursion stack.

public class SumRootToLeaf {
    int rootToLeaf = 0;

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }

    public void preorder(TreeNode node, int currSum) {
        if (node != null) {
            currSum = currSum * 10 + node.val;
            if (node.left == null && node.right == null) {
                rootToLeaf += currSum;
            }
            preorder(node.left, currSum);
            preorder(node.right, currSum);
        }
    }

    public static void main(String[] args) {
        SumRootToLeaf leaf = new SumRootToLeaf();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println(leaf.sumNumbers(root));
    }
}