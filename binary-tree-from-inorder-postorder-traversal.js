// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
var buildTree = function(inorder, postorder) {
    let map = {};
     let post_index = postorder.length - 1;
 
     // Build a hash map to store the index of each value in inorder traversal
     for (let i = 0; i < inorder.length; i++) {
         map[inorder[i]] = i;
     }
 
     let helper = function(in_left, in_right) {
         if (in_left > in_right) return null;
 
         // Get the root value from postorder
         let rootVal = postorder[post_index];
         let root = new TreeNode(rootVal);
 
         // Decrease post_index
         post_index--;
 
         // Get the index of the root value in inorder
         let index = map[rootVal];
 
         // Recursively build right and left subtrees
         root.right = helper(index + 1, in_right);
         root.left = helper(in_left, index - 1);
         return root;
     }
 
     return helper(0, inorder.length - 1);
 };