# Accepted on leetcode
# time - O(N), space - O(H) where H is height of recurrsion stack
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        return self.helper(root, 0)  # calling helper with initial values and returning it as tree.

    def helper(self, root, value):
        if root is None: return 0  # if no nodes return 0
        # if both left and right child are null then return previous value * 10 + current value.
        if root.left is None and root.right is None: return (value * 10 + root.val)
        # Add all the root to leaf paths on left and right as well to get final answer.
        return self.helper(root.left, value * 10 + root.val) + self.helper(root.right, value * 10 + root.val)