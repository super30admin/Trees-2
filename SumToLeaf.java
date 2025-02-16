// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I have used recursive approach to solve this problem. I have used a helper function which takes the root node and the current sum as the input. I have used a global variable sum to store the sum of all the paths from root to leaf. I have checked if the root is null, if yes, then I return. I have added the current node value to the current sum. If the root is a leaf node, then I add the current sum to the sum variable. I recursively call the helper function on the left and right child of the root node. I multiply the current sum by 10 while calling the helper function on the left and right child of the root node. This is because I need to calculate the sum of the path from root to leaf. So, I multiply the current sum by 10 and add the value of the current node to it. This way, I get the sum of the path from root to leaf. I keep on adding the sum of the path from root to leaf to the sum variable. Finally, I return the sum variable which contains the sum of all the paths from root to leaf.
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
class SumToLeaf {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int currSum){
        if(root == null){
            return;
        }
        currSum += root.val;
        if(root.left == null && root.right == null){
            sum += currSum;
        }

        helper(root.left, currSum*10);
        helper(root.right, currSum*10);
    }
}