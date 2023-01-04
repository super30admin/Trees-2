// TC = O(N)
// SC = O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
// class Solution {
//     // TC = O(N)
//     // TC = O(H)
//     int result;
//     public int sumNumbers(TreeNode root) {
//         helper(root, 0);
//         return result;
//     }
//     private void helper(TreeNode root, int currSum) {
//         // base
//         if(root == null) return;
//         //logic - at every step we are multiplying by 10 (parent's val) and adding current val and storing it as local sum -> currSum 
//         helper(root.left, currSum * 10 + root.val);
//         helper(root.right, currSum * 10 + root.val);
//         // then we are checking if it a leaf then add the value to result
//         // this can be done anywhere in any style like in/ pre/ postorder
//         if(root.left == null && root.right == null) result += currSum * 10 + root.val;
//     }
// }

// Iterative
class Solution {
    // TC = O(N)
    // TC = O(H)
    public int sumNumbers(TreeNode root) {
        int result = 0, currNum = 0;
        Stack<TreeNode> st = new Stack<>(); // 2 stacks as we are pushing root & currSum in rec st
        Stack<Integer> currNumSt = new Stack<>();
        while(root != null || !st.isEmpty()) {
            while(root != null) {
                currNum = currNum * 10 + root.val;
                st.push(root);
                currNumSt.push(currNum);
                root = root.left;
            }
            //st.pop()
            root = st.pop();
            currNum = currNumSt.pop();
            if(root.left == null && root.right == null) result += currNum; // elaf node
            root = root.right;
        }
        return result;
    }
}