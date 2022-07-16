//Time Complexity : O(n^2)
//Space Complexity : O(n^2)
//Can do using HAshmap:In this question, we will start with preorder we will pick the first element of preorder then we will search for that element in inorder then all the elements on its left are elements for left subtree for that root element and all the elements on its right are the elements for right subtree so we will be calling the same function again for left and right subtree.

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
    //Global variable declared
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length ==0)return null;
        
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length-1);
    }
    private TreeNode helper(int[] preorder,int[] inorder,int start,int end){
        //base
        if(start>end)return null;
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        
        root.left = helper(preorder,inorder,start,rootIdx-1);
        root.right = helper(preorder,inorder,rootIdx+1,end);
        return root;
    }
}