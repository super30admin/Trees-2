// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//approach : took a variable to count the sum on reaching everynode. if the left and right of a node is null, we add that to
// the result. we print the result at last.

// Your code here along with comments explaining your approach

import javax.swing.tree.TreeNode;

public class sumroot_leaf {
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
        int result;
        public int sumNumbers(TreeNode root) {
            this.result=0;
            helper(root,result);
            return result;

        }
        private void helper(TreeNode root, int cur)
        {
            if(root==null)  return;
            cur=cur*10+root.val;
            if(root.left==null && root.right==null)
            {
                result=result+cur;
                return;
            }
            helper(root.left,cur);
            helper(root.right,cur);
        }
    }
}
