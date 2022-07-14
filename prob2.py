# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if( root == None):
            return 0
        return self.helper(root,0)
        
    def helper(self,root,num):
        if (root == None):
            return
        
        if(root.left == None or root.right == None):
            return num * 10 + root.val
        
        return self.helper(root.left,num * 10 + root.val) + self.helper(root.right,num * 10 + root.val)
        