// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
  
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
    let helper = function(root, currNum) {
        // base case
        if(root === null) { return; }

        currNum = currNum * 10 + root.val;
        if(root.left === null && root.right === null) {
            result += currNum;
        }

        helper(root.left, currNum); 
        helper(root.right, currNum);
    }
    let result= 0;
    helper(root,0);
    return result;
};