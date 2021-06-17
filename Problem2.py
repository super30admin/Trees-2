# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        return self.helper(root,0)
        
    def helper(self,root,pres):
        if root == None:
            return 0
        if root.left == None and root.right == None:
            return pres * 10 + root.val
        
        pres = pres*10 + root.val
        
        return self.helper(root.left,pres) + self.helper(root.right,pres)
    