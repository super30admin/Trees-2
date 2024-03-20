# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List, Optional
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    sumVal = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        result = self.helper(root, 0)
        return self.sumVal
    
    def helper(self, root, curr):
        if(root == None): return
        curr = curr*10 + root.val

        if(root.left is None and root.right is None):
            self.sumVal+=curr
        
        self.helper(root.left, curr)
        self.helper(root.right, curr)