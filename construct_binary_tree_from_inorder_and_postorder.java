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
    int post_idx;
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> hmap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length - 1;
        int idx = 0;
        for(int val: inorder)
        {
            hmap.put(val, idx++);
        }
        return helper(0,inorder.length-1);
    }
    private TreeNode helper(int left, int right){
        // Base case
        if(left > right) return null;
        int root_val = this.postorder[post_idx--];
        int index = hmap.get(root_val);
        TreeNode root = new TreeNode(root_val);
        
        root.right = helper(index+1, right);
        root.left = helper(left, index-1);
        
        return root;
    }
}

// TC- O(N)
//SC - O(N)
/* Inorder used to get left and right of the root node values
Postorder to get the root node
Hashmap used to store inorder since left and right values are received from inorder.
Postorder is simply used to merely get a root node for each recursion*/
