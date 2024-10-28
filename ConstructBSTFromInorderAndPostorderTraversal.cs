// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    Dictionary<int,int> map;
    int idx;
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        this.idx = postorder.Length-1;
        this.map = new Dictionary<int,int>();

        for(int i=0; i<inorder.Length;i++){
            map.Add(inorder[i], i);
        }
        
        return Helper(postorder,0,inorder.Length-1);

    }

    private TreeNode Helper(int[] postorder, int start, int end){
        //base case
        if(start>end) return null;

        int rootVal = postorder[idx];
        idx--;
        int rootIdx = map[rootVal];
        TreeNode root = new TreeNode(rootVal);
         // Recursively build the right subtree, then the left subtree
        root.right = Helper(postorder, rootIdx + 1, end);
        root.left = Helper(postorder, start, rootIdx - 1);

        return root;
    }
}