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
/*
 * Approach is similar to how we construct BT from inorder and preorder
 * The only difference is the root is found at the last index of the postorder array and as we are starting from the last index, right subtree should be processed first
 */

 //TC: O(n) -> iterate over all the elements in the array
 // SC:O(n) -> map to store index and the elements in inorder array
class Solution {
    //global variables
    // to store elements with indices in inorder
    HashMap<Integer, Integer> map;
    // iterate over preorder array to get the root
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = postorder.length - 1; //root is at the last of the postorder array

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);   
    }

    // parameters: postorder to iterate through the array, pair of pointers to get the left and right subtree, we want the recursive call to bring the start and end with itself
    private TreeNode helper(int[] postorder, int start, int end){
        //base
        // start and end has crossed each other i.e no elements there, return null
        if(start > end)
            return null;
        //logic
        int rootVal = postorder[idx];
        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(postorder[idx]);
        idx--;

        //as we are starting from the end, right subtree should be processed first
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

        return root;

    }
}
