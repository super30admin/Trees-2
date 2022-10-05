// Time Complexity : O(n)
// Space Complexity : O(h)
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
 * @param {TreeNode} root
 * @return {number}
 */
// Keep sum global.
let sum;

var dfs = (root, number) => {
    // Base
    if (root === null) {
        return;
    }
    // Logic
    // If this is the leaf node, add to sum
    if (root.left === null && root.right === null) {
        sum += number * 10 + root.val;
    }
    // Traverse left and right roots and pass the number formed till now.
    dfs(root.left, number * 10 + root.val);
    dfs(root.right, number * 10 + root.val);
}
var sumNumbers = function (root) {
    sum = 0;
    // dfs(root, 0);

    // Iterative
    // Maintains 2 stacks. One for roots and other for numbers
    // Do inorder traversal.
    // If reached at leaf node, add number to sum
    let stack = [];
    let numbers = [];
    let number = 0;

    while (root != null || stack.length > 0) {
        while (root !== null) {
            number = number * 10 + root.val
            stack.push(root);
            numbers.push(number);
            root = root.left;
        }
        number = numbers.pop();
        root = stack.pop();

        if (root.left === null && root.right === null) {
            sum += number;
        }

        root = root.right;
    }
    return sum;
};