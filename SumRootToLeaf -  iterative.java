// Time Complexity : O(h) - height of tree
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

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
        int sum = 0;
        Stack<Pair<TreeNode,Integer>> st = new Stack<>();
        st.push(new Pair(root,0));
        while(root!=null && !st.isEmpty()){
            Pair<TreeNode, Integer> p = st.pop();
            TreeNode key = p.getKey();
            int curr_sum = p.getValue();
            
            if(key!=null){
                if(key.left==null && key.right==null){
                    curr_sum = curr_sum*10 + key.val;
                    sum += curr_sum;
                }
                st.push(new Pair(key.left, curr_sum*10 + key.val));
                st.push(new Pair(key.right, curr_sum*10 + key.val));
            }
        }
        return sum;
    }
}

