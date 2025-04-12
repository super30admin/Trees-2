// Time Complexity : O(n)
// Space Complexity : O(h) where h = height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - Create result var in global scope to store output. Create helper function for recurssion which takes root and currNum as params. currNum is upadated as currNum * 10 + root.val and then if root is leaf node then add currNum to result. Call helper() for left and right subtree with currNum.

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class SumRootToLeafNumbers {
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return this.result;
    }

    private void helper(TreeNode root, int currNum) {
        if(root == null) {
            return;
        }
        currNum = currNum * 10 + root.val;
        if(root.left == null && root.right == null) {
            //leaf node so add currNum to result
            result += currNum;
        }
        //go to left subtree
        helper(root.left, currNum);

        //go to right subtree
        helper(root.right, currNum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();
        int sum = solution.sumNumbers(root);
        System.out.println("Sum of all root-to-leaf numbers: " + sum);
    }
}
