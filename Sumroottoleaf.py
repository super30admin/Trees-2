'''
time complexity: O(n)
space complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        totalSum=0
        def helper(root,branchSum):
            #nonlocal totalSum
            if root==None:
                return

            
            helper(root.left,branchSum*10 + root.val)
            if(root.left==None and root.right==None):
                totalSum+= branchSum*10+root.val
            helper(root.right,branchSum*10 + root.val)

      
        
        helper(root,0)
        return totalSum
        