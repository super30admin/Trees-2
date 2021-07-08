// Time Complexity : O(N)
// Space Complexity : O(H) where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, did this in class

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */

// DFS
// var sumNumbers = function(root) {
//     return helper(root, 0);
// };

// const helper = (root, val1) => {
//     // Base Case
//     if (root == null) return 0;
//     if (root.left == null && root.right == null) return 10 * val1 + root.val;
    
//     // Logic
//     return helper(root.left, 10 * val1 + root.val) + helper(root.right, 10 * val1 + root.val)
// }

// BFS
var sumNumbers = function (root) {
    if (root == null) return 0;
    
    let sum = 0;
    let value = 0;
    let queue = [];
    queue.push([root, 0]);

    while (queue.length > 0) {
        let pair = queue.shift();
        let node = pair[0];
        let val1 = pair[1];
        
        if (node != null) {
            value = val1 * 10 + node.val;
            if (node.left == null && node.right == null) {
                sum += value;
            }
            queue.push([node.left, value]);
            queue.push([node.right, value]);
        }
    }
    return sum;
}
