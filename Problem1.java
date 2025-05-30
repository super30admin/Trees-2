// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//use hashmap to find the index of the root in inorder traversal
// then recursively build the tree using the index to split the inorder and postorder arrays
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
    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = inorder.length-1;
        for(int i =0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(postorder, 0, inorder.length-1);
    }
    TreeNode helper(int [] postorder, int start, int end){
        if(start>end) return null;
        int rootValue=postorder[idx];
        idx--;
        int rootIndex=map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.right = helper(postorder, rootIndex+1,end);
        root.left = helper(postorder, start, rootIndex-1);
        return root;
    }
}