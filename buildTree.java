// Time Complexity :O(n)
// Space Complexity :O(n)(hashmap)+O(H)(recursive stack)-->O(n) Asymptotic
// Did this code successfully run on Leetcode 106: yes
/* we can find the root from the postorder array as it is the last element present; then we can find the
 position of root element in the inorder array; the element towards the left in the order contribute to
 the left subtree and the elements to the right of the root in inorder contribute to the right subtree */


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
    int idx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||inorder==null||postorder.length==0)
            return null;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        idx=postorder.length-1;
        return helper(postorder,0,postorder.length-1);
    }
    private TreeNode helper(int[] postorder,int start,int end){
        if(start>end)
            return null;
        int rootVal=postorder[idx];
        idx--;
        int rootIdx=map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        root.right=helper(postorder,rootIdx+1,end);
        root.left=helper(postorder,start,rootIdx-1);
        return root;
    }
}