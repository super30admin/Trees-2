// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int post_idx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.postorder = postorder;
    this.inorder = inorder;
    this.post_idx = postorder.length - 1;
    int idx = 0;
    for(int n : inorder) {
        map.put(n, idx++);
    }
    return helper(0, inorder.length - 1);
}

public TreeNode helper(int in_left, int in_right) {
    if(in_left > in_right)
        return null;
    
    int root_val = postorder[post_idx];
    TreeNode root = new TreeNode(root_val);
    int index = map.get(root_val);
    post_idx--;
    root.right = helper(index + 1, in_right);
    root.left = helper(in_left, index - 1);
    return root;
}
}