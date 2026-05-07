// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    private Map<Integer, Integer> map;
    private int postOrderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.postOrderIdx = postorder.length-1;
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return helper(postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        //base
        if (start > end) return null;

        //logic
        int rootVal = postorder[this.postOrderIdx];
        int rootIdx = map.get(rootVal);
        this.postOrderIdx--;

        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

        return root;
    }
}