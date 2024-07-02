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

// Time Complexity : O(n) => As we are iterating over the n nodes
// Space Complexity : O(n) as we store all the nodes in inorder[] to a hash map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 Approach: Used recursive approach. First stored the inorder[] to a hashmap as using inorder[] we get the root node and the elements to its left will be the left child and to its right will be the right child. Then calculated the root value from postorder[] which will be the last element. Then processed the right child of root by looking up the hashmap and then similarly processed the right child
 */
class Solution {
    Map<Integer, Integer> inOrderMap;
    int postOrderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
            return null;
        }

        inOrderMap = new HashMap<>();
        postOrderIndex = postorder.length - 1;

        for(int i =0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, postorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right){

        if(left > right){
            return null;
        }

        int rootValue = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootValue);

        root.right = arrayToTree(postorder, inOrderMap.get(rootValue) +1, right );

        root.left = arrayToTree(postorder, left, inOrderMap.get(rootValue) -1);

        return root;
    }
}