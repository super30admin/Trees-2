// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class InPostOrderOptimized {
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.idx = postorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, map, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, HashMap<Integer, Integer> map, int start, int end) {
        // base
        if (start > end) return null;

        // logic
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        idx--;

        root.right = helper(postorder, map, rootIdx+1, end);
        root.left = helper(postorder, map, start, rootIdx-1);
        return root;
    }
}
