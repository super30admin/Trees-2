"""
Name: Srinidhi Bhat
Did it run on LC: Yes
Time and Space Complexity: O(n) and O(n) resp

Logic: Do a DFS and maintain sum in that path for far
Maintain a global variable for total sum and when you reach a leaf node,
i.e. when a path is completed, do a total sum.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        self.res = 0
        
        self.helper(root,self.res)
        return self.res
    
    def helper(self,root,value):
        if root:
            self.helper(root.left,value*10 + root.val)
            self.helper(root.right,value*10 + root.val)
            
            if root.left is None and root.right is None:
                self.res = self.res + value*10 + root.val
                