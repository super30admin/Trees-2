# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root):
        return self.helper(root, 0)

    def helper(self, root, prevSum):
        if not root:
            return 0
        prevSum = prevSum * 10 + root.val
        if not root.left and not root.right:
            return prevSum
        return self.helper(root.left, prevSum) + self.helper(root.right, prevSum)
