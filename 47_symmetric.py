# S30 Big N Problem #47 {Medium
# LC pproblem - 101. 

# Symmetric Tree

# Time Complexity : O(n) n=no. of nodes in the tree
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach
# Check the left and right sub tree 
# For left value of one sub-tree, check the right value of the other sub-tree and vice versa.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if root is None:
            return True
        return self.helper(root.left,root.right)
        
        
    def helper(self,root1,root2):
        
        if root1 is None and root2 is None:
            return True
        
        if (root1 is not None and root2 is None) or (root2 is not None and root1 is None):
            return False
        
        if root1.val!=root2.val:
            return False

        
        return root1.val==root2.val and self.helper(root1.left,root2.right) and self.helper(root1.right,root2.left)