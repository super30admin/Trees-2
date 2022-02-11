TC: O(n)
SC: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if(root==None): return 0
        sum =0
        
        def helper(root: Optional[TreeNode], num:int):
            nonlocal sum
            # base
            if(root== None): return 
            # logic
            helper(root.left, num*10+root.val)
            
            if(root.left == None and root.right == None):
                sum+=num*10 + root.val
            helper(root.right, num*10+root.val)
        helper(root, 0)
        return sum
            
        
        