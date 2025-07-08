// Time Complexity : O(n)
// Space Complexity : O(n) for the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I used the logic that for inorder, all elements to the left of root are left subtree, all elements to right are right subtree - I traverse in postorder from the end - this is the root, I keep a track of index using idx variable and decrement it at each step. From the end it goes like root, right and then left. So, once I have the root, I find the left and right bounds - I find its index in the inorder array and the index to the left represents the left subtree, right represents right subtree. When going for the right subtree, I update the left bound and when going to the right subtree, I update the left bounds.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    private int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++) inorderMap.put(inorder[i], i);
        idx = postorder.length-1;
        return builder(postorder, 0, inorder.length-1, inorderMap);
    }

    public TreeNode builder(int[] postorder, int left, int right, HashMap<Integer, Integer> inorderMap){
        if(left>right) return null;
        TreeNode root = new TreeNode(postorder[idx--]);
        int inorderIdx = inorderMap.get(root.val);
        root.right = builder(postorder, inorderIdx+1, right, inorderMap);
        root.left = builder(postorder, left, inorderIdx-1, inorderMap);
        return root;
    }
}