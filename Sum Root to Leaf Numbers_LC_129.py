# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return []
        self.count = 0
        self.recurse(root, 0)
        return self.count

    def recurse(self, root, path):
        # base case
        if not root:
            return
        if not root.left and not root.right:
            path = (path * 10) + root.val
            self.count += path
            return
         
        # logic
        self.recurse(root.left, (path * 10) + root.val)
        self.recurse(root.right, (path * 10) + root.val)
