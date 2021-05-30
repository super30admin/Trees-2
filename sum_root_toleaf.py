"""129. Sum Root to Leaf Numbers
Time Complexity: 0(N)
Space Complexity: O(maxDepth)"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.output = 0
        
    def sumNumbers(self, root: TreeNode) -> int:
        currsum=0
        self.helper(root,currsum)
        return self.output
        
    def helper(self,root,currsum):
        if root is None:
            return 
        
        currsum = currsum*10+root.val
        
        if root.left == None and root.right == None:
            self.output += currsum
            return
        
        self.helper(root.left,currsum)
        self.helper(root.right,currsum)
    
    
    
        