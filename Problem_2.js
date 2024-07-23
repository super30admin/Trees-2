//Leetcode: https://leetcode.com/problems/sum-root-to-leaf-numbers/
// Time Complexity : O(n)
// Space Complexity : O(1) not including the recursion call stack (i.e O(h) - maximum calls in a stack is height of the tree at any given moment)
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
    var res = 0;
    // We run any DFS to get the res from root to leaf.
    // At every function, we pass the levels's current number
    var sumNumberHelper = (root, currNum) => {

        // base
        if(root === null) return;
        //logic
        currNum = currNum*10 + root.val; //At each level, calculate the number and pass that to recursive calls
        if(root.left === null && root.right === null) // Check if leaf node, if leaf then add currNum to result 
            res+=currNum;
        sumNumberHelper(root.left, currNum); // left child recursion
        sumNumberHelper(root.right, currNum); // right child recursion
    }
    sumNumberHelper(root, 0);
    return res;
};