#  Time Complexity : O(n)
#  Space Complexity : O(h)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this :no

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
    
        def helper(curSum, root):
            result=0
            if not root:
                return 0
            result += curSum*10 + root.val
            if not root.left and not root.right:
                return result
            return helper(result, root.left)+helper(result, root.right)
        
        return helper(0, root)