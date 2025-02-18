// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    int[] inorder;
    int[] postorder;
    HashMap<Integer,Integer> indexmap=new HashMap<>();
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        this.index=postorder.length-1;

        for(int i=0;i<inorder.length;i++){
            indexmap.put(inorder[i],i);
        }

        return helper(0,inorder.length-1);

    }

    public TreeNode helper(int left,int right){
        //base
        if(left>right) return null;

        //logic
        int val=postorder[index--];
        int pos=indexmap.get(val);
        TreeNode node=new TreeNode(val);

        node.right=helper(pos+1,right);
        node.left=helper(left,pos-1);

        return node;
    }
}