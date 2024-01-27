## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.result
    def helper(self, root: TreeNode, currentSum):
        if root == None:
            return
        currentSum = (currentSum * 10) + root.val
        if root.left == None and root.right == None:
            self.result += currentSum
        self.helper(root.left, currentSum)
        self.helper(root.right, currentSum)
