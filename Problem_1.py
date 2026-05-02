# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder, postorder):
        n = len(inorder)
        self.index = n - 1
        self.in_map = {}
        for i in range(n):
            ele = inorder[i]
            self.in_map[ele] = i
        return self.helper(postorder, 0, n - 1)

    def helper(self, postorder, start, end):
        if start > end:
            return None
        root = TreeNode(postorder[self.index])
        idx = self.in_map[root.val]
        self.index -= 1
        root.right = self.helper(postorder, idx + 1, end)
        root.left = self.helper(postorder, start, idx - 1)
        return root
