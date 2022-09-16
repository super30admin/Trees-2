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
        Stack<Integer> numst = new Stack<>();
        int currnum = 0;
        int result = 0;
        
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                currnum = currnum*10+root.val;
                st.push(root);
                numst.push(currnum);
                root = root.left;
            }
            //pop
            
            root = st.pop();
            currnum = numst.pop();
            
            //check for leaf
            if(root.left == null && root.right == null)
            {
                result += currnum;
            }
            root = root.right;
            
        }
        
        return result; 
        
    }
}