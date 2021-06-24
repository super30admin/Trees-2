// Time Complexity : O(n)
// Space Complexity : O(n) + O(h) == O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * Postorder contains the root node at the very end of the list.
 * we pick the root node by taking the last element from the postorder array and find the left and right subtrees from the inorder array
 * we construct the left and right subtrees for inorder and preorder arrays and recursively call the same function
 * For faster lookups for index in inorder array, we craeted a Hashmap for all the inorder elements and the index
 */

class Solution {
    Map<Integer, Integer> inorderMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        inorderMap = new HashMap<>();
        
        // construct the hashmap
        for(int i=0;i<inorder.length;i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int in_start, int in_end, int post_start, int post_end) {
        if(post_start > post_end) {
            // there is no node in the postorder to process
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[post_end]);
        
        // get the inorder index for the root
        int inorder_ind = inorderMap.get(postorder[post_end]);
        
        int in_left_start = in_start;
        int in_left_end = inorder_ind - 1;
        
        int post_left_start = post_start;
        int post_left_end = post_start + (in_left_end - in_left_start);
        
        root.left = buildTreeHelper(inorder, postorder, in_left_start, in_left_end, post_left_start, post_left_end);
        
        int in_right_start = inorder_ind + 1;
        int in_right_end = in_end;
        
        int post_right_start = post_left_end + 1;
        int post_right_end = post_end - 1;
        
        root.right = buildTreeHelper(inorder, postorder, in_right_start, in_right_end, post_right_start, post_right_end);
        
        return root;
        
        
    }
}