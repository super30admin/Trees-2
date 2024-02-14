// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
   
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int prevVal) {
        int sum = 0;
        if (root == null) {
            return 0;
        }

        int currNodeVal = prevVal * 10 + root.val;
        if(root.left == null && root.right == null) {
            sum += currNodeVal;
        }

        sum += helper(root.left, currNodeVal);
        sum += helper(root.right, currNodeVal);
        return sum;
    }
}

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