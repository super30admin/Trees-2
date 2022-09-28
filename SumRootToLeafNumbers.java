import java.util.Stack;


// Time Complexity : O(n) where n = number of elements in tree
// Space Complexity : O(h) where h = height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//129. Sum Root to Leaf Numbers (Medium) - https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
// Time Complexity : O(n) where n = number of elements in tree
// Space Complexity : O(h) where h = height of tree
//class Solution {
//    public int sumNumbers(TreeNode root) {
//        Stack<TreeNode> nodeStack = new Stack<>();
//        Stack<Integer> sumStack = new Stack<>();
//        int currSum = 0, result = 0;
//        
//        while (root != null || !nodeStack.isEmpty()) {
//            while (root != null) {
//                currSum = currSum * 10 + root.val;
//                nodeStack.push(root);
//                sumStack.push(currSum);
//                root = root.left;
//            }
//            
//            root = nodeStack.pop();
//            currSum = sumStack.pop();
//            
//            // check if root is leaf
//            if (root.left == null && root.right == null) {
//                result += currSum;
//            }
//            root = root.right;
//        }
//        
//        return result;
//    }
//}

// Time Complexity : O(n) where n = number of elements in tree
// Space Complexity : O(h) where h = height of the tree
//class Solution {
//    
//    int result;
//    
//    public int sumNumbers(TreeNode root) {
//        helper(root, 0);
//        return result;
//    }
//    
//    private void helper(TreeNode root, int currSum) {
//        // base
//        if (root == null) return;
//        
//        if (root.left == null && root.right == null) {
//            result += currSum * 10 + root.val;
//        }
//        // logic
//        helper(root.left, currSum * 10 + root.val);
//        
//        helper(root.right, currSum * 10 + root.val);
//    }
//}

// Time Complexity : O(n) where n = number of elements in tree
// Space Complexity : O(h) where h = height of the tree
class Solution {
    
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int currSum) {
        // base
        if (root == null) return 0;
        
        currSum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return currSum;
        }
        // logic
        return helper(root.left, currSum) + helper(root.right, currSum);
    }
}