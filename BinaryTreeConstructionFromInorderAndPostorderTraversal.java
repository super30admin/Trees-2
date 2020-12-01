package Nov30;

import java.util.HashMap;
import java.util.Map;

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
class BinaryTreeConstructionFromInorderAndPostorderTraversal {
    
    /* 
	Time Complexity: O(n) where n is size of given arrays.
	Because we will process each element of the array once.

	Space Complexity: O(n) where n is size of given arrays.
	Because we are using extra space of hashmap of n size.
	      
	Did this code successfully run on Leetcode : Yes

	Any problem you faced while coding this : No

	Approach:
    Hashmap used to store elements of inorder array and their corresponding indexes.
    Global variable postIndex used to iterate through postorder array and find root node for each recursive call.
    After finding root, we will index of root in inorder array.
    Make recursive calls for right subtree and left subtree by iterating through startIndex+1 TO end and start TO inIndex-1 respectively.
 
*/
    int postIndex = 0;
    Map<Integer, Integer> hm;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // creating and populating a hashmap with all elements of inorder array as the key and their indexes in inorder array as the value
        hm = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
    
       postIndex = postorder.length-1;
       return helper(postorder, inorder, 0, inorder.length-1);
    }
    
     // HELPER FUNCTION 
    public TreeNode helper(int[] postorder, int[] inorder, int start, int end) {
        
        // base condition for recursion for inorder array => when current subtree from inorder array has been processed
        if(start > end) {
            return null;
        }
         // base condition for recursion for postorder array => when all nodes in postorder have already been processed
        if (postIndex < 0) {
            return null;
        }
        
        // create the current root node 
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        int inIndex = hm.get(root.val);
        // process root's right first and then root's left unlike Binary Tree construction from Inorder and Preorder Traversal problem where the order was opposite.
        root.right = helper(postorder, inorder, inIndex+1, end);
        root.left = helper(postorder, inorder, start, inIndex-1);
        
        return root;
        
    }
    
}
