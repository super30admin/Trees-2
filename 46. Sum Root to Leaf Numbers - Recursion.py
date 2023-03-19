# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        return self.helper(root, 0)

    def helper(self, root, num):
        if root is None:
            return 0

        if root.right is None and root.left is None:
            return num * 10 + root.val

        return self.helper(root.left, num * 10 + root.val) + self.helper(root.right, num * 10 + root.val)

# TC =O(n).
# Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No




