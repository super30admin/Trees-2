// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);

        return root;
    }

    public TreeNode buildTree(int[] postorder, int prest, int preed, int[] inorder, int inst, int ined,
            HashMap<Integer, Integer> map) {
        if (prest > preed || inst > ined)
            return null;

        TreeNode root = new TreeNode(postorder[preed]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inst;
        root.left = buildTree(postorder, prest, prest + numsLeft - 1, inorder, inst, inRoot - 1, map);
        root.right = buildTree(postorder, prest + numsLeft, preed - 1, inorder, inRoot + 1, ined, map);

        return root;
    }
}