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
// Time Complexity: O(n) All the nodes are traversed in tree node. As there is no further computations while going back to parent no extra time complexity added.
// Space Complexity: We have not used any additional datastructure. O(1)
// Did you complete it on leetcode: Yes
// Any problems faced: Understood in class

// Write your approach here:
// Idea here is to recursively check if left child is present then make parent a ten's/hundredth.. place by multiplying with 10 and adding it to current root untill leaf node is reached.
// Similarly perform recursion on right tree.
// on achieving completion of each leaf node sum, add them to return as left subtree sum + right subtree sum.
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return sumHelper(root, 0);
    }
    public int sumHelper(TreeNode root, int currSum) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) {
            return currSum*10 + root.val;
        }
        return sumHelper(root.left, currSum*10+root.val) + sumHelper(root.right, currSum*10+root.val);
    }
}