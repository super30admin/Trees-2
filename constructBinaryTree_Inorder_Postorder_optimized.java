// Time complexity : O(n)  Traversing the node once
// Space Complexity : O(n) : Hashmap

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
    int p;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Last element contains root. so start with last index
        p = postorder.length - 1;
        
        //Create a hashmap to store the inorder element and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i= 0; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        
        return helper(postorder, map, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] postorder, HashMap<Integer, Integer> map , int start, int end){
        
        // Edge cases
        if (start > end || p == -1){
            return null;
        }
        
        // Get the index of the root from the postorder (last element of postorder = root)
        int inorderIndex = map.get(postorder[p]);
        
        // Create the root
        TreeNode root =  new TreeNode(postorder[p]);
        
        // Update the new root 
        p--; // valid only right subproblem So, start with right
        
        //Compute the subproblems
        root.right =  helper(postorder, map, inorderIndex + 1 , end);
        root.left =  helper(postorder, map, start, inorderIndex -1);
        
        
        return root;
    }
}