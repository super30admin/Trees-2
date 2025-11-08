// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
import java.util.HashMap;

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
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=postorder.length-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1,map);
    }
    private TreeNode helper(int[] postorder, int start, int end, HashMap<Integer,Integer> map){
        if(start > end) return null;
        int currVal = postorder[index];
        index-=1;
        int currIdx = map.get(currVal);
        TreeNode node = new TreeNode(currVal);
        node.right = helper(postorder, currIdx+1, end, map);
        node.left = helper(postorder, start, currIdx-1, map);
        return node;
    }
}
