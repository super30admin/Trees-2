// Time Complexity : O(n)
// Space Complexity : O(h) - worst case: O(n) if we come across a skewed tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

var sumNumbers = function (root) {
  if (root === null) return null;
  let gSum = 0;

  const dfs = (root, cSum) => {
    if (root.left !== null) {
      dfs(root.left, cSum * 10 + root.left.val);
    }

    if (root.right !== null) {
      dfs(root.right, cSum * 10 + root.right.val);
    }

    if ((root.left === null) & (root.right === null)) {
      gSum += cSum;
    }
  };

  dfs(root, root.val);
  return gSum;
};
