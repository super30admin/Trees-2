# Time Complexity: O(n), n of nodes visited in the tree
# Spcae Complexity: O(h), h: height of the tree
    # Worst Case: O(h) = O(n) - Unbalanced Tree
    # Best Case: O(log n) - Balanced Tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        self.helper(root, 0)
        return self.result
    
    def helper(self, root: Optional[TreeNode], curr):
        # base
        if root == None: 
            return
        # logic
        curr = curr * 10 + root.val
        self.helper(root.left, curr)
        if root.left == None and root.right == None:
            self.result += curr
        self.helper(root.right, curr)