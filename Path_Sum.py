"""
Time Complexity : sumNumbers_recursive - O(n)
                  sumNumbers_iterative - O(n)
Space Complexity : sumNumbers_recursive - O(h) (stack space)
                   sumNumbers_iterative - O()
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def sumNumbers_recursive(self, root: TreeNode) -> int:
        if root == None:
            return 0
        
        tot = self.helper(root, 0)
        return tot
        
    def helper(self, root, val):
        # base case
        if not root: return 0
        if root.left == None and root.right == None: return (val*10) + root.val 
        # recursive case
        return self.helper(root.left, val*10 + root.val) + self.helper(root.right, val*10 + root.val)
    
    def sumNumbers_iterative(self, root: TreeNode) -> int:
                
    
    
root = TreeNode(1)
left = TreeNode(2)
right = TreeNode(3)
root.left = left
root.right= right

s = Solution()
print(s.sumNumbers_recursive(root))