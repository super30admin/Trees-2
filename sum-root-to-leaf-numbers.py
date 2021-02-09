'''
Time complexity: O(n)
Space complexity: O(maxDepth)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def sumNumbers(self, root: TreeNode) -> int:
        self.output = 0
        if root is None:
            return self.output
        self.recur(root, 0)
        return self.output
    
    def recur(self, root, current):
        if root is None:
            return
        current = current * 10 + root.val
        if root.left is None and root.right is None:
            self.output = self.output + current
            return
        self.recur(root.left, current)
        self.recur(root.right, current)
            