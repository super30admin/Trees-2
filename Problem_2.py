"""
## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(n)
# SC: O(n)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def findNumbers(curr, num):
            nonlocal result
            #base condition
            if curr is None: return 1
            
            #logic
            num = num * 10 + curr.val
            if curr.left is None and curr.right is None:
                result += num
            findNumbers(curr.left, num)
            findNumbers(curr.right, num)

            return result

        result = 0
        return findNumbers(root, 0)