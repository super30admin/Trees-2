//https://leetcode.com/problems/sum-root-to-leaf-numbers/
//// Time Complexity : O(n) visits every node
//// Space Complexity : stack size O(tree depth)
//// Did this code successfully run on Leetcode : yes!
//// Any problem you faced while coding this :

//  keeping the current node value from call to call

//// Your code here along with comments explaining your approach

// recurse left and right
// let current to parent to track the sum
// if you are at a leaf add in the current sum to output
// else not at a leaf recurse left and right
var sumNumbers, treeNode;

treeNode = function(val, left = null, right = null) {
  return Object.assign(Object.create(treeNode.prototype), {
    val: val,
    left: left,
    right: right
  });
};

sumNumbers = function(root) {
  var output, recurse;
  output = {
    sum: 0
  };
  recurse = function(root, curr) {
    var nextCurrentSum;
    if (root === null) {
      return;
    }
    nextCurrentSum = curr * 10 + root.val;
    if (root.left === null && root.right === null) {
      output.sum += nextCurrentSum;
      return;
    }
    recurse(root.left, nextCurrentSum);
    return recurse(root.right, nextCurrentSum);
  };
  recurse(root, 0);
  return output.sum;
};

//sumNumbers(treeNode(1, treeNode(2), treeNode(3)));
sumNumbers(treeNode(4, treeNode(9, treeNode(5), treeNode(1)), treeNode(0)));

//# sourceMappingURL=problem2-sum-root-to-leaf-nodes.js.map
