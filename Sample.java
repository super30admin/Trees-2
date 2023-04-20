## Sum Root to leaf
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        self.current = 0
        self.dfs(root,0)
        return self.current


    def dfs(self, root: Optional[TreeNode], curval: int):
        if root == None:
            return
        if root.left == None and root.right == None:
            self.current += curval*10 + root.val
        self.dfs(root.left,curval*10 + root.val)
        self.dfs(root.right, curval*10 + root.val)