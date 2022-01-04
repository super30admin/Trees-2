# Time Complexity : O(n)
# Space Complexity:o(n)
#  Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.sum = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.sum

    def helper(self, root, currSum):
        # base case
        if root is None:
            return None

        if root.left is None and root.right is None:
            self.sum += currSum * 10 + root.val
        # recursion
        currSum = currSum * 10 + root.val
        self.helper(root.left, currSum)
        self.helper(root.right, currSum)

