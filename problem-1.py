# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def dfs(self,root,num):
        if not root:
            return 
        
        curno=num*10+root.val
        
        if not root.left and not root.right:
            self.ans+=curno
        
        self.dfs(root.left,curno)
        self.dfs(root.right,curno)
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.ans=0
        self.dfs(root,0)
        return self.ans