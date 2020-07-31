// Time Complexity :O(n)
//      n: number of elements
// Space Complexity :O(n)
//      n: number of elements
//      for HashMap
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

import java.util.HashMap;
// Your code here along with comments explaining your approach
// Using similar solution as PREORDER and INORDER question
class Problem1 {

    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    
    // global hashmap
    HashMap<Integer, Integer> map;
    // root index for post order
    int postOrderRootId;

    /** returns tree */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // edge case
        if(inorder.length ==0|| postorder.length==0 || inorder.length != postorder.length)
            return null;
        
        // creating map
        map = new HashMap<>();
        for(int i=0; i<inorder.length;i++)
            map.put(inorder[i],i);
        // index of root
        postOrderRootId = postorder.length-1;

        return helper(inorder, postorder, 0, inorder.length-1);
        
    }
    
    /** helper function */
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        // base case: not in range
        if(start>end)
            return null;
        // get index of root for inorder
        int rootIdx = map.get(postorder[postOrderRootId--]);
        // add 
        TreeNode root = new TreeNode(inorder[rootIdx]);
        // first right since we have post order
        root.right = helper(inorder, postorder, rootIdx+1, end);
        // than left
        root.left = helper(inorder, postorder, start, rootIdx-1);
        
        // return tree
        return root;
    }
}