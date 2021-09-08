// Time Complexity : O(n)
// Space Complexity : O(h) h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Working with the local parameter in recursion

var sumNumbers = function (root) {
    if (!root) return 0;

    var helper = function (root, num) {
        if (!root) return 0;
        if (root.left === null && root.right === null) {
            return num * 10 + root.val;
        }

        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val)

    }
    return helper(root, 0);
};