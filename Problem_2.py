# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
TC - O(n)
SC - O(h)
"""
class Solution:
    def __init__(self):
        self.sum = 0

    def helper(self, root: Optional[TreeNode], currsum):
        if root == None:
            return
        currsum = currsum * 10 + root.val
        self.helper(root.left, currsum)
        if root.left == None and root.right == None:
            self.sum += currsum
        self.helper(root.right, currsum)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        self.helper(root, 0)
        return self.sum