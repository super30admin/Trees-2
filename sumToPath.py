"""
Intuition: A local sum will be required which will be stored at each and every node.
#####################################################################
Time Complexity : O(N) 
Space Complexity : O(H), H = Height of the tree
#####################################################################
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        return self.helper(root, 0, 0)
        
    def helper(self,root, currentSum, result):
        if root == None:
            return 0
        
        if root.left == None and root.right == None:

            return ((currentSum*10 + root.val))
        
        currentSum = (currentSum*10 + root.val)
        result1 = self.helper(root.left, currentSum)
        result2 =self.helper(root.right, currentSum, result)
        return result1 + result2
