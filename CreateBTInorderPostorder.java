// Time Complexity : O(n) each node visited once
// Space Complexity : O(n) hashmap stores n nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - - Postorder traversal gives: left -> right -> root
//    - The last element of postorder is always the root.
//    - Use a HashMap to store the indices of inorder elements for O(1) access.
//    - Recursively construct the tree:
//        - Start from the end of postorder (root),
//        - Use Recursion on the right subtree first (since postorder is reversed),
//        - Then recursion on the left subtree.

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class CreateBTInorderPostorder {
    HashMap<Integer, Integer> inmap;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inmap = new HashMap<>();
        int n = inorder.length; //no of nodes
        this.index = n - 1;

        for(int i = 0; i < n; i++) {
            this.inmap.put(inorder[i], i);   //put elements from inorder traversal and their index in inorder in Map
        }

        return helper(postorder, 0, n - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if(start > end) {  //base case
            return null;
        }

        int rootval = postorder[index];   //index is tracking root index
        index--;
        int rootIndexInorder = inmap.get(rootval);  //get index of root value in inorder traversal
        //now make root node
        TreeNode root = new TreeNode(rootval);
        //now make right subtree first since traversal is left->right->root i.e. root is in right half of array.
        //call recurssion to make right subtree
        root.right = helper(postorder, rootIndexInorder + 1, end);

        //call recurssion to make left subtree
        root.left = helper(postorder, start, rootIndexInorder - 1);

        //return root as answer
        return root;
    }

}
