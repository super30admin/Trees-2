// Time Complexity : O(n)
// Space Complexity : O(n)
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
class Solution {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();

        int sum = 0;
        int currNum = 0;

        while(root != null || !st.isEmpty()){
            while(root != null){
                currNum = currNum * 10 + root.val;
                st.push(root);
                numSt.push(currNum);
                root = root.left;
            }
            //pop
            root = st.pop();
            currNum = numSt.pop();

            //check leaf
            if(root.left == null && root.right == null)
                sum += currNum;

            root = root.right;
        }
        return sum;
    }
}