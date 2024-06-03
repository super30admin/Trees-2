// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :     Yes
// Any problem you faced while coding this : No


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
        int ret = 0;
        Queue <Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode curr = p.getKey();
            int value  = p.getValue();
            if(curr != null){
                value = curr.val + 10*value;
                if(curr.left == null && curr.right == null){
                    ret += value;
                }
                q.offer(new Pair(curr.left, value));
                q.offer(new Pair(curr.right, value));
            } 
        }
        return ret;
    }

}