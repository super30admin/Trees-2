
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
/*
Time: O(n)
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
class Solution{

    HashMap<Integer, Integer> map = new HashMap();
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        int iStart = 0;
        int iEnd = inorder.length - 1;

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i); // memoization

        return helper(inorder, postorder, iStart, iEnd);

    }

    public TreeNode helper(int[] inorder, int[] postorder, int iStart, int iEnd) {
        if (iStart > iEnd) // if there is no elements to construct subtrees
            return null;

        TreeNode root = new TreeNode(postorder[idx]);

        int iRoot = map.get(postorder[idx]); // pick up post_idx element as a root
        // recursion 
        idx--;
          // build right subtree
        root.right = helper(inorder, postorder, iRoot + 1, iEnd);
         // build left subtree
        root.left = helper(inorder, postorder, iStart, iRoot - 1);

        return root;

    }

}