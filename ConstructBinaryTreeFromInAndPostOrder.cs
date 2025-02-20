// time complexity O(n)
// space complexity O(n)
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
public class Solution
{
    int postRtIdx = 0;
    Dictionary<int, int> inDict = new Dictionary<int, int>();
    public TreeNode BuildTree(int[] inorder, int[] postorder)
    {
        postRtIdx = postorder.Length - 1;
        for (int i = 0; i < inorder.Length; i++)
        {
            inDict.Add(inorder[i], i);
        }
        return helper(postorder, 0, inorder.Length - 1);
    }

    private TreeNode helper(int[] postorder, int inStart, int inEnd)
    {
        // base
        if (inStart > inEnd)
        {
            return null;
        }

        // logic        
        int postRootVal = postorder[postRtIdx];
        TreeNode postRtNode = new TreeNode(postRootVal);
        postRtIdx--;

        int inRtIdx = inDict[postRootVal];
        postRtNode.right = helper(postorder, inRtIdx + 1, inEnd);
        postRtNode.left = helper(postorder, inStart, inRtIdx - 1);

        return postRtNode;
    }
}