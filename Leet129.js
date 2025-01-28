// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    return helper(root,0);
};
function helper(root,num){
    if(root==null){return 0;}
    num = num*10+root.val;
    if(root.left==null && root.right==null){
        return num;
    }
    return helper(root.left,num) + helper(root.right,num);
}
