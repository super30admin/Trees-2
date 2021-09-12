// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
        Stack<Integer> numStack = new Stack<>();
        int num=0; int sum=0;
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                num = num*10 + root.val;
                numStack.push(num);
                root = root.left;
            }
            root = st.pop();
            num = numStack.pop();
            if(root.left == null && root.right == null){
                //leaf node!
                sum += num;
            }
            root = root.right;
        }
        return sum;
    }
};