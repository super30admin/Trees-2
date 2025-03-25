//Construct Binary Tree from Inorder and Postorder Traversal
//Time COmplexity: O(n)
//Space Complexit: O(H)

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
    int post_index;
    HashMap<Integer,Integer> map = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        post_index = postorder.length-1;
        //create hashmap of val and its index
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,postorder,0,inorder.length-1);
        
    }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        // no elements to construct tree
        if(post_index<0 || start>end) return null;
        //get the index for postorder root in the inorder
        int inorderIdx = map.get(postorder[post_index--]);
        TreeNode root = new TreeNode(inorder[inorderIdx]);

        root.right = helper(inorder,postorder,inorderIdx+1,end);
        root.left = helper(inorder,postorder,start,inorderIdx-1);
        return root;
    }
}
