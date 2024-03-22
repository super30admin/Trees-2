# TC = O(n)   -- Traversing whole tree
# SC = O(h).  -- height of the tree, spave required for stack
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.sum1 = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.sum1

    def helper(self, root, curr):
        if root == None:
            return
        curr = curr * 10 + root.val
        if root.left == None and root.right == None:
            self.sum1 += curr
        self.helper(root.left, curr)
        self.helper(root.right, curr)
