//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//// Time Complexity : O(n) we are slicing up the arrays no revisiting array elements
//// Space Complexity : O(tree depth) we consume this much space recursing
//// Did this code successfully run on Leetcode : yes!
//// Any problem you faced while coding this :

//  none pretty straighforward after doing inorder, preorder

//// Your code here along with comments explaining your approach

// insights: rootvalue will be the last value in postorder[]
// use the length of left and right
// length of left tree is rootvalue_index-0 in inorder
// length of right tree is inorder.length-rootvalue_index in inorder
// carry over the lengths into the postorder array calculations
var buildTree, treeNode;

treeNode = function(val, left = null, right = null) {
  return Object.assign(Object.create(treeNode.prototype), {
    val: val,
    left: left,
    right: right
  });
};

buildTree = function(inorder, postorder) {
  var index, inleft, inright, postleft, postright, rootVal;
  if (inorder.length < 1 || postorder.length < 1) {
    return null;
  }
  rootVal = postorder[postorder.length - 1];
  index = inorder.findIndex(function(i) {
    return rootVal === i;
  });
  inleft = inorder.slice(0, index);
  inright = inorder.slice(index + 1);
  postleft = postorder.slice(0, index);
  postright = postorder.slice(index, postorder.length - 1);
  return treeNode(rootVal, buildTree(inleft, postleft), buildTree(inright, postright));
};

//# sourceMappingURL=problem1-btree-from-inorder-postorder.js.map
