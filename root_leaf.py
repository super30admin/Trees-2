# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        def dfs(root,curr):
            nonlocal tot
            if not root.left and not root.right:
                curr=curr*10 + root.val
                tot+=curr
                return
            curr=curr*10 + root.val
            if root.left:
                dfs(root.left,curr)
            if root.right:
                dfs(root.right,curr) 
        tot=0
        dfs(root,0)
        return tot
        