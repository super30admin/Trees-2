#https://leetcode.com/problems/sum-root-to-leaf-numbers/
#// Time Complexity : O(n) visits every node
#// Space Complexity : stack size O(tree depth)
#// Did this code successfully run on Leetcode : yes!
#// Any problem you faced while coding this :
#
#  keeping the current node value from call to call
#
#// Your code here along with comments explaining your approach
#
# recurse left and right
# let current to parent to track the sum
# if you are at a leaf add in the current sum to output
# else not at a leaf recurse left and right

treeNode = (val, left = null, right = null) -> Object.assign(
  Object.create(treeNode::),
  val: val
  left: left
  right: right
)

sumNumbers = (root) ->
  output = sum: 0

  recurse = (root, curr) ->
    return if root is null

    nextCurrentSum = curr * 10 + root.val

    if root.left is null and root.right is null
      output.sum += nextCurrentSum
      return

    recurse(root.left, nextCurrentSum)
    recurse(root.right, nextCurrentSum)

  recurse(root, 0)

  output.sum

#sumNumbers(treeNode(1, treeNode(2), treeNode(3)));
sumNumbers(
  treeNode(4, treeNode(9, treeNode(5), treeNode(1)), treeNode(0)))
