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
//Time Complexity: O(N)
 //Space Complexity: O(N)
class Solution {
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    int length;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        length=postorder.length-1;
        return helper(postorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] postorder,int start,int end){
        //BaseCase
        if(length<0 ||start>end ){
            return null;
        }
        //Logic
        int ele=postorder[length];
        length--;
        int inorderLoc=map.get(ele);
        TreeNode root=new TreeNode(ele);
        if(start==end){
            return root;
        }
        root.right=helper(postorder,inorderLoc+1,end);
        root.left=helper(postorder,start,inorderLoc-1);
        return root;
    }
}