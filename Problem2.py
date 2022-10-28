#Time Complexity - O(n) 
#Space Complexity - O(h) where h is height of tree
#Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)
    
    def helper(self, root, path):
        if root == None:
             return 0
        
        path = (path * 10) + root.val
        
        if root.left is None and root.right is None:
            return path
        
        return self.helper(root.left, path) + self.helper(root.right, path)