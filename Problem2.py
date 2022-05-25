#Time Complexity: O(n)
#Space Complexity: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.res = 0
        self.helper(root,0)
        return self.res
    
    def helper(self,root, currSum):
        if root == None:
            return
        if root.left== None and root.right == None:
            
            self.res += currSum*10 + root.val
            return 
        
        self.helper(root.left, currSum*10 + root.val)
        
        self.helper(root.right, currSum*10 + root.val)
        
        