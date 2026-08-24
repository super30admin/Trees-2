//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

// Space Complexity O(n)
//Time Complexity o(n)
// using inorder to find the index and iterate through postorder


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
    HashMap<Integer,Integer> map = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIndex = postorder.length-1;

        for(int i = 0 ; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(postorder, 0, postorder.length-1);
    }

    public TreeNode helper(int[] postorder,int  start,int end){
        if(start > end) {
            return null;
        }
        int rootVal = postorder[postIndex];
        postIndex--;
        int rootIndex = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        //buildright
        root.right = helper(postorder, rootIndex+1, end);
        root.left= helper(postorder, start, rootIndex-1);
        return root;
       
    }
}
