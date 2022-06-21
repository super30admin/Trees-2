#Time Complexity: O(n)
#Space Complexity: O(1)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result=0
        self.dfs(root,0)
        return self.result
        
    def dfs(self,root,prev):
        if root==None:
            return 0
        prev=prev*10+root.val
        if root.left == None and root.right==None:
            self.result+=prev
            return
        self.dfs(root.left,prev)
        self.dfs(root.right,prev)
  