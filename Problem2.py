# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # declaring a global variable to calculate the sum and calling the helper function with the root and currNum as 0
        # we are keeping track of sum till that node using currNum
        self.sum = 0
        return self.helper(root,0)
    
    def helper(self, root, currNum):
        # checking if root is null, then return 0
        if root is None:
            return 0
        # if we reach a lead node, only then we add the value to the sum, for that we have to calculate the number that node by doing the calculations
        if root.left is None and root.right is None:
            self.sum += currNum *10 + root.val
        
        # we recursilevly call the helper function for left and right subtree
        # this way we sum up all the lead nodes
        self.helper(root.left, currNum *10 + root.val)
        self.helper(root.right, currNum *10 + root.val)
        
        return self.sum
        
