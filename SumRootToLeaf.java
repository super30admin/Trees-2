/*
* Approach:
*  1. Iterate through the path using DFS and
        update the currsum by muliplying with 10 and 
        adding root.val
* 
*  2. When we reach left node(both left and right are null)
        return the currsum.
* 
*  3. if root is null, return 0

    return the sum of left and right subtrees to parent.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(h)
    height of the tree
* 
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

public class SumRootToLeaf {
    // int sum = 0;

    // private void sumNumbers(TreeNode root, int value) {
    // if (root == null)
    // return;

    // int currVal = ((value * 10) + root.val);

    // if (root.left == null && root.right == null)
    // sum += currVal;

    // sumNumbers(root.left, currVal);
    // sumNumbers(root.right, currVal);
    // }

    // public int sumNumbers(TreeNode root) {
    // sumNumbers(root, 0);
    // return sum;
    // }

    private int sumNumbers(TreeNode root, int value) {
        if (root == null)
            return 0;

        int currVal = (value * 10) + root.val;

        if (root.left == null && root.right == null)
            return currVal;

        int left = sumNumbers(root.left, currVal);
        int right = sumNumbers(root.right, currVal);

        return left + right;
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
}
