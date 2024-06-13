'''
## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

Time Complexity : O(n) where n is total nodes in the tree
Space Complexity : O(h) where h is the maximum height of the tree (for the recursion stack)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach:
- perfrom DFS on the tree and at every node maintain the current number formed.
- maintain the totalSum variable in global scope outside recursive calls such as instance variable
- when we reach a left node in the DFS recursion, add the number generated to the totalSum variable in the global scope.
- after the DFS is completed on the entire tree, return the totalSum

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
  def sumNumbers(self, root):
    self.totalSum = 0
    self.sumNumbersRecursive(root, 0) # pass root and 0 as initial value of current number
    return self.totalSum

  def sumNumbersRecursive(self, root, currentNumber):
    #base case
    if not root:
      return

    # current number formed by the digits collected uptil now
    currentNumber = currentNumber * 10 + root.val

    # if the current node is a leaf node, add it to the totalSum instance variable
    if root.left == None and root.right == None:
      self.totalSum += currentNumber
      return

    # recurse on left and right sub tree
    self.sumNumbersRecursive(root.left, currentNumber)
    self.sumNumbersRecursive(root.right, currentNumber)
