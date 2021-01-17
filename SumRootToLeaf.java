import javax.swing.tree.TreeNode;

// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Do a preorder search recursivelly and add the values in to a totalsum variable

//doing preorder search
public class SumRootToLeaf {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int totalSum = 0;
        public int sumNumbers(TreeNode root) {
            preorder(root, 0);
            return totalSum;
        }

        public void preorder(TreeNode root, int sum){
            //base case
            if(root == null) return;
            sum = sum * 10 + root.val;
            if(root.left == null && root.right == null) totalSum += sum;

            //add left and right node values
            preorder(root.left, sum);
            preorder(root.right, sum);
        }
    }
}
