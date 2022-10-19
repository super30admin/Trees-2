// Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
let map;
let idx;
let generateTree = (postorder, inorder, start, end) => {
    // Base
    if (start > end)
        return null;

    // Logic
    // The last element of postorder will be the next root
    let postorderRoot = postorder[idx];
    idx--;
    let index = map.get(postorderRoot);
    let root = new TreeNode(postorderRoot);

    // Get the right roots
    root.right = generateTree(postorder, inorder, index + 1, end);
    // Get left roots
    root.left = generateTree(postorder, inorder, start, index - 1);

    return root;
}
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function (inorder, postorder) {
    if (inorder === null || postorder === null || inorder.length === 0 || postorder.length === 0)
        return null;
    map = new Map();
    idx = postorder.length - 1;
    inorder.forEach((ele, i) => map.set(ele, i));
    return generateTree(postorder, inorder, 0, inorder.length - 1);
};