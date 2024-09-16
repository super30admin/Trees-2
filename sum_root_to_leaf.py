"""
Time complexity - O(N)
Space complexity - O(N) worst case
Runs on leet code
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    stack = [0]
    counter = 0
    
    def preorder(self,root: TreeNode) :
        
        if root== None :
            return 
        
        self.stack.append(self.stack[-1]*10 + root.val)
        
        if not root.left and not root.right :
            self.counter+= self.stack.pop()
            return
        
        if root.left :
            self.preorder(root.left)
        
        if root.right :
            self.preorder(root.right)
        
        self.stack.pop()
        return
        
    def sumNumbers(self, root: TreeNode) -> int:
        self.stack = [0]
        self.counter = 0
        self.preorder(root)
        return self.counter
        
        
