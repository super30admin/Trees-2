//Sum Root to Leaf Numbers (LC 129)

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : I feel like my approach would work here using preorder traversal


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
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
    let sum = 0;
    let stack = [];
    stack.push([root, 0]);
    while(stack.length > 0){
        let popValue = stack.pop();
        let root = popValue[0];
        let currNumber = popValue[1];
        if(root !== null){
            currNumber = currNumber * 10 + root.val;
            if(root.left !== null && root.right !== null){
                sum += currNumber;
                
            } else {
                stack.push([root.right, currNumber]);
                stack.push([root.left, currNumber]);
            }
        }
    }
    return sum;
};