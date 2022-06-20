// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {

    // Building tree
    Map<Integer, Integer> map = new HashMap<>();

    int postorderIndex;

    private TreeNode treeBuilder(int[] postorder, int left, int right) {

        // No element left -> return null
        if (left > right) return null;

        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        // We are going tn reverse order here
        // reversePostorder -> Root Right Left
        // It will build the tree
        root.right = treeBuilder(postorder, map.get(rootVal) + 1, right);
        root.left = treeBuilder(postorder, left, map.get(rootVal) - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // build Map
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        postorderIndex = postorder.length - 1;

        return  treeBuilder(postorder, 0, inorder.length - 1);

    }
}