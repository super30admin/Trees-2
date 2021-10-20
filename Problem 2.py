# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root):
        self.total = 0

        if not root:
            return self.total

        self.helper(root, 0)

        return self.total

    def helper(self, root, current):
        if not root:
            return

        current = current * 10 + root.val

        if not root.left and not root.right:
            self.total += current

        self.helper(root.left, current)
        self.helper(root.right, current)

        return self.total


