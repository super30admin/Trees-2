// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BTFromInorderAndPostOrder {
    HashMap<Integer, Integer> map = new HashMap();
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        for(int i =0; i < inorder.length; i++)
            map.put(inorder[i], i);

        postIdx = postorder.length-1;
        return buildTreeHelper(0, postorder.length-1, inorder, postorder);
    }

    public TreeNode buildTreeHelper(int start, int end, int[] inorder, int[] postorder)
    {
        if(start > end)
            return null;

        int rootNodeVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootNodeVal);
        int indexOfRootInorder = map.get(rootNodeVal);

        postIdx--;

        root.right = buildTreeHelper(indexOfRootInorder+1, end, inorder, postorder);
        root.left = buildTreeHelper(start, indexOfRootInorder-1, inorder, postorder);

        return root;
    }
}
