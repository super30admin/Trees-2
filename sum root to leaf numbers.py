# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        self.Sum = 0
        
        def helper(node,path):
            if node:
                if not node.left and not node.right:
                    self.Sum += path*10 + node.val
                    
                helper(node.left,path*10 + node.val)
                helper(node.right,path*10 + node.val)
            
        helper(root,0)
        return self.Sum
    
