import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We maintain map for inorder
// and traverse postorder from the end
// check if sub tree is valid (start < end) and recursively process left and right parts
class BinaryTreeFromInorderAndPostOrder {
    HashMap<Integer, Integer> map;
    int postOrderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        postOrderIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        // base
        if (start > end || postOrderIndex < 0)
            return null;

        // logic
        int rootVal = postorder[postOrderIndex--];
        int rootIdx = map.get(rootVal);

        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.right = helper(postorder, rootIdx + 1, end);
        rootNode.left = helper(postorder, start, rootIdx - 1);

        return rootNode;
    }
}
