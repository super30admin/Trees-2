
// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
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
    Dictionary<int, int> inorderMap = new Dictionary<int, int>();
    int idx = 0;
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        this.idx = postorder.Length - 1;
        //Add inorder array items to hashmap which will be used in identifying root node, left and right sub tree nodes.
        for(int i = 0; i < inorder.Length; i++) {
            inorderMap.Add(inorder[i], i);
        }
        //Traverse through postorder array recursively to build binary tree nodes using inorderMap.
        return BuildNodes(postorder, postorder.Length - 1, 0);
    }

    private TreeNode BuildNodes(int[] postorder, int start, int end) {
        if(start < end) return null;
        
        int rootVal = postorder[idx];
        idx--;
        int rootIdx = inorderMap[rootVal];

        //Root
        TreeNode root = new TreeNode(rootVal);
        //Build Right Subtree
        root.right = BuildNodes(postorder, start, rootIdx + 1);
        //Build Left Subtree
        root.left = BuildNodes(postorder, rootIdx - 1, end);

        return root;
    }

}