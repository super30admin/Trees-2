#Time Complexity O(n)
#Space Complexity O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        res = 0
        def helper(root, res):
            if root == None: 
                return 0
            res = res*10 + root.val
            if root.left == None and root.right == None:
                return res
            return helper(root.left, res)+ helper(root.right, res)
            
        
        return helper(root, 0)
