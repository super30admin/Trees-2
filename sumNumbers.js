// Time Complexity : O(n) where n is number of tree nodes
// Space Complexity : O(h) where h is tree height

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

//Using Stack
var sumNumbers = function(root) {
    let stack = [];
    let numStack = [];
    let number = '';
    let sum = 0;
    while(root !== null || stack.length !== 0) {
        while(root !== null) {
            stack.push(root);
            number += root.val;
            numStack.push(number);
            root = root.left;
        }
        console.log(number);
        root = stack.pop();
        number = numStack.pop();
        if(root.left === null && root.right === null) {
            sum += parseInt(number);
        }
        root = root.right; 
    }
    return sum;
};

//Using inbuild recursion solution

// let numStack;
// let number;
// let sum;
// var inorder = function(root) {
//     //base case
//     if(root === null) return;
//     //action
//     number += root.val;
//     numStack.push(number);
//     inorder(root.left);
    
//     number = numStack.pop();
//     if(root.left === null && root.right === null) {
//         sum += parseInt(number);
//     } 
//     inorder(root.right);
// }

// var sumNumbers = function(root) {
//     numStack = [];
//     number = '';
//     sum = 0;
//     if(root === null) return 0;
//     inorder(root);
//     return sum;
// };