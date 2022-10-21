#Tc O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def dfs(current,num):
            if not current:
                return 0
            num=num*10 + current.val
            if not current.left and not current.right:
                return num
            return dfs(current.left,num) + dfs(current.right,num)
        return dfs(root,0)