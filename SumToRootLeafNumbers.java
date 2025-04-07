
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
This program calculates the total sum of all numbers formed by root-to-leaf paths in a binary tree.
It uses a recursive helper function that builds the number as it traverses down the tree by multiplying
the current sum by 10 and adding the node's value. When a leaf node is reached, the current number
is returned. The final result is the sum of all such numbers from all root-to-leaf paths.
The solution runs in O(n) time and uses O(h) space, where n is the number of nodes and h is the
tree height.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class SumToRootLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    private int helper(TreeNode root, int currSum)
    {
        if(root==null)
            return 0;


        currSum=currSum*10+root.val;

        if(root.left==null && root.right==null)
        {
            return currSum;
        }

        int left= helper(root.left,currSum);
        int right= helper(root.right,currSum);


        return left+right;
    }
}