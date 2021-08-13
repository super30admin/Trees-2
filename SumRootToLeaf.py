"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        return self.helper(root, 0, 0)
    def helper(self, root: Optional[TreeNode], currSum: int, Sum: int):
        if not root:
            return 0
        # Traversing through all left nodes and calculating
        # current sum until the leaf node and then updating Sum
        currSum = currSum * 10 + root.val
        if not root.left and not root.right:
            Sum += currSum
            return Sum
        return self.helper(root.left, currSum, Sum) + self.helper(root.right, currSum, Sum)