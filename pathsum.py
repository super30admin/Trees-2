# // Time Complexity :O(n) 
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.summ=0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        num=0
        self.inorder(root,num)
        return self.summ
    def inorder(self,root,num):
      
        if not root:
            return
        
        
        else:
            
            
            self.inorder(root.left,num*10+root.val)
            if not root.left and not root.right:
                num=num*10+root.val
                
                self.summ=self.summ+num
                
                self.summ
          
            self.inorder(root.right,num*10+root.val)
        
        