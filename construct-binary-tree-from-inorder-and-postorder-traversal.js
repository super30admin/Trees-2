// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, same as inorder/preorder problem with minor changes.

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
let index,
    map;
var buildTree = function(inorder, postorder) {
    if (inorder == null || inorder.length == 0) return null;
    
    index = postorder.length - 1; 
    map = new Map;
    for (let i = 0; i < inorder.length; i++) {
        map.set(inorder[i], i);
    }
    return helper(inorder, postorder, 0, inorder.length - 1);
};

var helper = function(inorder, postorder, start, end) {
    // Base Case
    if (start > end) return null;
    
    // Logic
    let root = new TreeNode(postorder[index--]);
    
    let inIdx = map.get(root.val);
    root.right = helper(inorder, postorder, inIdx + 1, end);
    root.left = helper(inorder, postorder, start, inIdx - 1);
    
    return root;
};
