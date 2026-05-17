// Time Complexity : O(n)
// Space Complexity : O(n) to store the dictionary which contains the mapping for inorder array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I use the postorder list to keep track of values of root nodes (Postorder = Recursively traverse left subtree -> Recursively traverse right subtree -> Visit root) and inorder list to obtain information about
    what nodes belong to the left subtree of a given node and what nodes belong to the right subtree of a given node. 
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
public class Solution
{
    private Dictionary<int, int> inorderLookup;
    private int index;
    public TreeNode BuildTree(int[] inorder, int[] postorder)
    {
        inorderLookup = new();
        index = postorder.Length - 1;

        for (int i = 0; i < inorder.Length; i++)
        {
            inorderLookup[inorder[i]] = i;
        }

        return Helper(0, inorder.Length - 1, postorder);
    }

    public TreeNode Helper(int st, int end, int[] postorder)
    {
        if (st > end)
        {
            return null;
        }

        int rootVal = postorder[index];
        index -= 1;
        int rootIndex = inorderLookup[rootVal];
        TreeNode temp = new TreeNode(rootVal);
        temp.right = Helper(rootIndex + 1, end, postorder);
        temp.left = Helper(st, rootIndex - 1, postorder);

        return temp;

    }
}