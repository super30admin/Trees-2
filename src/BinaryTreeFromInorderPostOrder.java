// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    Map<Integer, Integer> valIndexMap = new HashMap<>();
	// index to keep track of postorder array - global so we can use same across all recursive calls
    int index;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        	//create hashmap to retrieve index of the element from the inorder
        for(int i=0; i<inorder.length;i++ ){
           valIndexMap.put(inorder[i], i); 
        }
        
        index = postorder.length-1;
        return helper(postorder, inorder, 0, postorder.length-1);
    }
    
     private TreeNode helper(int[] postorder, int[] inorder, int start, int end) {
        
        //if index reaches 0 of postorder (note index is global so shared across all recursive calls) , we exhausted all nodes
    	    // or if start crosses end means nothing on that side
    	    if(start > end || index < 0) return null;
        
        //index of current node from the inorder
        int inIdx = valIndexMap.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index--]);
        
        //for post order first do right, then left 
        //why - because we are sharing global var index for post order
        root.right = helper(postorder, inorder, inIdx+1,end); 
        root.left = helper(postorder, inorder, start, inIdx-1);
 
        return root;
    }
}