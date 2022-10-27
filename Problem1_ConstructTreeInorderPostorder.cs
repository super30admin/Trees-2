// Approach : postorder is in LRN, meaning if we traverse from last to front the first node would be root. In the inorder everything to the left of root ia left subtree and right of root is right subtree.
// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(h) where h is the height of the tree;

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
    int postorderIndex;
    int[] inorder, postorder;
    Dictionary<int, int> inorderIndices;
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postorderIndex = postorder.Length-1;
        inorderIndices = new Dictionary<int, int>();
        
        for(int i=0; i< inorder.Length; i++)
            inorderIndices.Add(inorder[i], i);
        
        return BuildTree(0, inorder.Length-1);
    }
    
    public TreeNode BuildTree(int start, int end){
        if(start>end) return null;
        
        var nodeval = postorder[postorderIndex];
        postorderIndex--;
        
        var right = BuildTree(inorderIndices[nodeval]+1, end);
        var left = BuildTree(start, inorderIndices[nodeval]-1);
        
        return new TreeNode(nodeval, left, right);
        
    }
}