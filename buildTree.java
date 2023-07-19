// Time Complexity : O(m+n), where m is the number of elements in the first array and n is the number of elements in the second array.
// Space Complexity : O(m), where m is the number of elements in the first array.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. last element in postorder is the root, and find that root in the inorder array.
 * 2. elements to the left of the root in inorder array are the left subtree and elements to the right of the root in inorder array are the right subtree.
 * 3. Based on this, we can recursively build the tree.
 */

import java.util.HashMap;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inMap){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(inorder, inStart, inRoot-1, postorder, postStart, postStart+numsLeft-1, inMap);
        root.right = buildTree(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inMap);

        return root;
    }
}