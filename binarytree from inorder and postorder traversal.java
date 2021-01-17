// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

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
    //to store the value and index of inorder
    HashMap<Integer,Integer> map;
    //index of preoder get mainitained here
    //int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //set index
        //index = postorder.length - 1;
        if(postorder.length == 0) return null;
        //intialize the haspmap
        map = new HashMap<>();
        //put the inorder values and index into hashmap
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        //call the helper function for recursion
        return helper(inorder,postorder,0,inorder.length-1,postorder.length - 1);
    }
    private TreeNode helper(int[] inorder,int[] postorder, int start, int end, int idx){
        //base
        if(start > end) return null;
        //logic
        //find the root value
        int rootVal = postorder[idx];
        //make a root
        TreeNode root = new TreeNode(rootVal);
        //get the root index in the inorder
        int rootIndex = map.get(rootVal);
        //call helper on right subtree. Start is root index plus 1
        root.right = helper(inorder, postorder, rootIndex+1, end, idx-1);
        //call helper on the left subtree
        root.left = helper(inorder, postorder, start, rootIndex-1, idx-(end-rootIndex)-1);
        return root;
    }
    
}