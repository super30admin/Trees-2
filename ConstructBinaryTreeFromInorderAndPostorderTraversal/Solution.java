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

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Last element in postorder is the root of the tree. Element before is right root and then left root. Elements to the left and right
 * of this root is the left and right subtree resp. in inorder traversal.
 * To find root index from the inorder, create a HashMap -> (element, index) instead of iterating over the inorder array everytime
 */
class Solution {

    Map<Integer, Integer> map;
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        map = new HashMap<>();
        index = postorder.length-1;

        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);

        return helper(postorder, 0, postorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {

        if(start > end) return null;

        int rootValue = postorder[index--];
        int rootIndex = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.right = helper(postorder, rootIndex+1, end);
        root.left = helper(postorder, start, rootIndex-1);

        return root;
    }
}

/*
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(postorder.length == 0) return null;

        int iLen = inorder.length, pLen = postorder.length;
        int rootValue = postorder[pLen-1];
        int rIdx = -1;

        for(int i=0; i<iLen; i++)
            if(inorder[i] == rootValue)
                rIdx = i;

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rIdx+1, iLen);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, inLeft.length, pLen-1);

        TreeNode root = new TreeNode(rootValue);
        root.right = buildTree(inRight, postRight);
        root.left = buildTree(inLeft, postLeft);

        return root;
    }
}*/
