# Time Complexity O(N)
# Space Complexity o(N)





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    sum = 0 
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,0)
        
        return self.sum
        
    
    def helper(self,root , num):
        
        if root == None:
            return
        self.helper(root.left ,  num*10 + root.val)
        
        if root.left == None and root.right == None:
            
            self.sum += num *10 + root.val
            
        self.helper(root.right , num*10 +root.val)
        
        
        
        
        
        
        
        
        
        