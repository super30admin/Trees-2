/**
 * @param {TreeNode} root
 * @return {number}
Intuition:
 Traverse from root to leaf while building the path.
 When a leaf is reached, convert the path into a number and add it to the total.
 Recursion naturally talkes care of  all the root-to-leaf paths.

 T.C: O(N), S.C: O(N)
 */
var sumNumbers = function(root) {
    let totalSum = 0;
    const helper = (root, path='') => {
    // base
    if(!root) return;

    // action
    path += root.val;

    if(!root.left && !root.right){
       totalSum +=  Number(path);
       return;
    }

    // recursion
    helper(root.left, path);
    helper(root.right, path);
    }
    helper(root);
    return totalSum;
};