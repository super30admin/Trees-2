# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        
        def helper(root, n):
            
            if root == None:
                return
            if root.left == None and root.right == None:
                self.result += n * 10 + root.val
            helper(root.left,n*10+root.val)
            helper(root.right,n*10+root.val)
            
        helper(root,0)
        return self.result