'''
## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

Time Complexity : O(n) where n is total nodes in the tree
Space Complexity : O(h) where h is the maximum height of the tree (for the recursion stack)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach:
- The postorder traversal has the root values from right to left.
- For every root value in postorder traversal locate the position in the inorder traversal
  - all values in the right sub array of that positon form the right sub tree.
  - all values in the left sub array of that position form the left sub tree.
- Continue the above steps recursively while traversing the postorder traversal from right to left.
'''

# Definition for a binary tree node.
class TreeNode:
  def __init__(self, val=0, left=None, right=None):
    self.val = val
    self.left = left
    self.right = right

class Solution:
  def buildTree(self, inorder, postorder):
    self.inorderIndices = { value: index for index, value in enumerate(inorder) }
    self.postorder = postorder
    self.postorderRootIdx = len(postorder) - 1
    return self.buildTreeRecursive(0, len(inorder) - 1)

  def buildTreeRecursive(self, inorderLeftIdx, inorderRightIdx):
    # base case
    if inorderLeftIdx > inorderRightIdx:
      return None

    # create a root node
    rootValue = self.postorder[self.postorderRootIdx]
    rootNode = TreeNode(rootValue)

    # move postorder index to left
    self.postorderRootIdx -= 1

    # locate position in inorder sequence
    inorderRootIdx = self.inorderIndices[rootValue]

    # connect the right sub tree and left sub tree
    # by recursing on the right and left side of the position in the inorder sequence within the current sub array indices
    rootNode.right = self.buildTreeRecursive(inorderRootIdx + 1, inorderRightIdx)
    rootNode.left = self.buildTreeRecursive(inorderLeftIdx, inorderRootIdx - 1)

    #return the root node
    return rootNode
