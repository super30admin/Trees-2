/*
  Time complexity: O(n)
  Space complexity:O(n)

  Code ran successfully on Leetcode: Yes

  Approach: The root values from postOrder are chosen from the end as the post order traversal follows the rule left-right-root. Also the recursive calls are altered to have the right recursive call before the left recursive call.

*/

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
    int[] inorder;
    int[] postorder;
    int idx;
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        idx = postorder.Length-1;

        Dictionary<int,int> dict = new();

        for(int i=0;i<inorder.Length;i++)
        {
            dict[inorder[i]]=i;
        }

        return helper(dict,0,inorder.Length-1);
    }

    private TreeNode helper(Dictionary<int,int> dict, int start, int end)
    {
        if(start>end)
            return null;

        TreeNode root = new TreeNode(postorder[idx]);
        
        int rootIndex = dict[postorder[idx]];
        idx--;

        root.right = helper(dict, rootIndex+1,end);
        root.left = helper(dict, start, rootIndex-1);

        return root;
    }
}
