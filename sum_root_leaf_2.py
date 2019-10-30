"""
Solution without stack and using only gobal variable.

Time complexity O(N)
Space complexity O(height)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    parent_sum = 0
    counter = 0
    
    def preorder(self,root: TreeNode) :
        
        self.parent_sum = self.parent_sum*10 + root.val
        if not root.left and not root.right :
            self.counter+= self.parent_sum
        if root.left :
            self.preorder(root.left)

        if root.right :
            self.preorder(root.right)
        
        self.parent_sum = int(self.parent_sum/10)
        return
        
    def sumNumbers(self, root: TreeNode) -> int:
        self.parent = 0
        self.counter = 0
        if root== None :
            return 0 

        self.preorder(root)
        return self.counter
        
        
