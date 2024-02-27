//Optimized Approach:


// Time Complexity : O(n) , Adding values to map is O(n) finding root index takes o(1) time using mapc & using two pointers takes O(1) time
// Space Complexity : O(n), storing in hashmap
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : use an hashmap to fetch the index
//in O(1) and used two pointers to mark the start and end ( left and right) of the current root.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        this.idx = n - 1;
        this.map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); // value to index mapping
        }

        return dfs(postorder, 0, n - 1);
    }

    private TreeNode dfs(int[] postorder, int start, int end) {
        //base case
        if (start > end) return null;

        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal); // index in inorder

        // move right first because post order left right root.
        //right : start = root idx + 1 , end = same;
        root.right = dfs(postorder, rootIdx + 1, end);
        //left : start = same & end = root idx -1;
        root.left = dfs(postorder, start, rootIdx - 1);

        return root;
    }
}
