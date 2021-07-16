// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
    Map<Integer, Integer> inMap;
    //this has to be intialized inside buildTree function, as we start traversing end to start of post order array
    //root is at last in post order
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0)
            return null;
        
        //intialize postIdx to length-1
        int n = postorder.length;
        postIdx = n-1;
        
        //create inorder hashMap
        inMap = new HashMap<>();
        for(int i=0; i<n; i++){
            inMap.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0 , n-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        //base
        if(start > end)
            return null;
        //logic
        //create tree using postorder root
        int rootVal = postorder[postIdx];
        postIdx--;
        TreeNode root = new TreeNode(rootVal);
        
        //find the root index in inorder
        int rootIdx = inMap.get(rootVal);
        //call right subtree first and then left subtree, because Post order is used to build the tree
        root.right = helper(inorder, postorder, rootIdx+1, end);
        root.left = helper(inorder, postorder, start, rootIdx-1);
        
        return root;
    }
}