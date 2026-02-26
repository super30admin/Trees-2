# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : On reaching leaf node, return the number formed so far as it is a complete path.
# Return the sum of results from left and right subtrees to get the final answer.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, root: Optional[TreeNode], currNum: int) -> int:
        if root == None:
            return 0

        currNum = currNum * 10 + root.val

        if root.left is None and root.right is None:
            return currNum

        left = self.helper(root.left, currNum)
        right = self.helper(root.right, currNum)

        return left + right


    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)

        