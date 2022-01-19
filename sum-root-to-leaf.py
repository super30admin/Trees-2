# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:

    sumval = 0

    def helper(self, root, num):

        # base condition
        if root == None:
            return

        if root.left == None and root.right == None:
            self.sumval = self.sumval + num * 10 + root.val

        # logic
        self.helper(root.left, num * 10 + root.val)
        self.helper(root.right, num * 10 + root.val)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sumval = 0
        self.helper(root, 0)
        return self.sumval
