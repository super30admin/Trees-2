// Time Complexity : O(n)
// Space Complexity : O(n) - for the hashmap and recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : thinking about the order of traversal and how to use the postorder index correctly

// Your code here along with comments explaining your approach: using hashmap to store the inorder values and their indices, then using postorder index to get the root value and recursively building the left and right subtrees. The postorder index is decremented after each root is processed, and the right subtree is built before the left subtree since we are processing postorder from the end.
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
    HashMap<Integer,Integer> map;
    int postOrderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.map = new HashMap<>();
        postOrderIdx = postorder.length-1;

        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){

        if(start > end) return null;

        int rootVal = postorder[postOrderIdx];
        int rootIdx = map.get(rootVal);
        postOrderIdx--;

        TreeNode node = new TreeNode(rootVal);

        node.right = helper(postorder,rootIdx+1,end);
        node.left = helper(postorder,start,rootIdx-1);
      
        return node;
    }   
}
