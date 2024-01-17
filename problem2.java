// Time Complexity : O(N)
// Space Complexity : O(H), where H is the height of the binary tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// algorithm explores all root-to-leaf paths to calculate the sum of numbers formed along paths.

import javax.swing.tree.TreeNode;

public class problem2 {
    int rootToLeaf = 0;

    public void preorder(TreeNode r, int currNumber) {
        if (r != null) {
            currNumber = currNumber * 10 + r.val;
            // if it's a leaf, update root-to-leaf sum
            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(r.left, currNumber);
            preorder(r.right, currNumber) ;
        }
    }

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }
}
