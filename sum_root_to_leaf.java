// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
//Iterative soln: Create two stacks for the node and its corresponding sum till that level
// when we found that node to be leaf, takeout the currSum till then and add it to the result
class Solution {
    public int sumNumbers(TreeNode root) {
        int currNum =0;
        int result=0;
        Stack<Integer> numSt = new Stack<>();
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){ //Inorder (DFS)
            while(root!=null){
                currNum = currNum*10+root.val;
                st.push(root);
                numSt.push(currNum);
                root = root.left;
            }
            root = st.pop();
            currNum = numSt.pop();
            if(root.left == null && root.right==null){
                result = result+currNum;
            }
            root = root.right;
        }
        return result;
    }
}

//RECURSIVE SOLN
class solution{
    int result;
    public int func(TreeNode root){
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int sum){
        if(root == null)
        return ;
        if(root.left == null && root.right == null){
            result = result+sum*10+root.val;
        }
        helper(root.left,sum*10+root.val);
        helper(root.right,sum*10+root.val);
    }
}