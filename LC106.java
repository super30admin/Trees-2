//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
/*
Time: O(n)
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class LC106 {

    HashMap<Integer, Integer> map = new HashMap();
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int iStart = 0;
        int iEnd = inorder.length - 1;

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i); // memoization

        return helper(preorder, inorder, iStart, iEnd);

    }

    public TreeNode helper(int[] preorder, int[] inorder, int iStart, int iEnd) {
        if (iStart > iEnd)
            return null;

        // Output root node is nothing but starting node of preorder
        TreeNode root = new TreeNode(preorder[idx]);

        // Find the position of the root node in the inorder array
        int iRoot = map.get(preorder[idx]);
        idx++;

        root.left = helper(preorder, inorder, iStart, iRoot - 1);
        root.right = helper(preorder, inorder, iRoot + 1, iEnd);

        return root;

    }

}
