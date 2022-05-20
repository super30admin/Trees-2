# Time Complexity : O(h) where h is height of the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.total = 0
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.inOrder(root, 0)
        return self.total
        
    def inOrder(self, root, currSum):
        if root is None:
            return
        
        self.inOrder(root.left, currSum * 10 + root.val)
        
        if root.left is None and root.right is None:
            self.total += currSum * 10 + root.val
        
        self.inOrder(root.right, currSum * 10 + root.val)