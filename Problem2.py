# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
    
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root: return 0
        stack, res = [(root, root.val)], 0
        while stack:
            tree, value = stack.pop()
            if not tree.left and not tree.right:
                res += value
            if tree.left:
                stack.append((tree.left, value*10+tree.left.val))
            if tree.right:
                stack.append((tree.right, value*10+tree.right.val))
        return res
