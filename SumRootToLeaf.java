// Time Complexity : O(n) where n is the number od tree nodes.
// Space Complexity : O(h) where h is the height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class SumRootToLeaf {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    public int sumNumbers(TreeNode root) {
        rootToLeaf(root, 0);
        return total;
    }
    int total = 0;
    public void rootToLeaf(TreeNode node, int curr) {
        if(node == null) return;

        curr = (curr*10) + node.val;
        if(node.left == null && node.right == null) total+= curr;

        rootToLeaf(node.left, curr);
        rootToLeaf(node.right, curr);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        SumRootToLeaf sum = new SumRootToLeaf();
        System.out.println("The sum of all root to leaf is: " + sum.sumNumbers(root));

    }
}
