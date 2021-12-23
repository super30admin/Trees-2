// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Its a bit complicated to implement, remember the base case of helper function


// Your code here along with comments explaining your approach
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) return null;

        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        idx = postorder.length-1;
        return helper(postorder, 0, postorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        //base
        if (start>end) return null;

        //logic
        int rootIdx = map.get(postorder[idx]);
        TreeNode root = new TreeNode(postorder[idx]);
        idx--;

        //recurse
        root.right = helper(postorder, rootIdx+1, end);
        root.left = helper(postorder, start, rootIdx-1);

        //return
        return root;
    }
}
