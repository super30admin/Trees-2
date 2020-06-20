# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        return self.helper(root,0)
    
    def helper(self,root,currsum):
        #base case
        if root==None:
            return 0
        if root.left==None and root.right==None:
            return currsum*10+root.val
        
        left=self.helper(root.left,currsum*10+root.val)
        right=self.helper(root.right,currsum*10+root.val)
        return left+right
        
 #time complexity is O(n)
 #space is O(h)
