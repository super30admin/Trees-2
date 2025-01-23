# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        self.sumv = 0
        def dfs(root,curstr):
            if root is None:
                return
            curstr += str(root.val)
            if root.left is None and root.right is None:
                self.sumv += int(curstr)
                return
            dfs(root.left,curstr)
            dfs(root.right,curstr)
        dfs(root,"")
        return self.sumv
        