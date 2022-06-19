"""Approach:

Start at root node and pass it along with its value to the helper
helper terminates when root is None.
We maintain gsum as global sum for each path
If root has left or root has right, call helper on them along with currSum*10+root.left.val or currSum*10+root.right.val
If both left and right are empty - then we add currSum to global sum
TC O(N) as you have to visit each node
SC O(H) as you will have at most of tree heigh H in the recursive stack
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    gsum = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return -1
        self.helper(root, root.val)
        return self.gsum
    
    def helper(self, root:Optional[TreeNode], currSum:int):
        # base
        if not root:
            return
        
        # logic
      
        if not root.left and not root.right:
            self.gsum += currSum
            return
            
        if root.left:
            self.helper(root.left, currSum * 10 + root.left.val)
        
        if root.right:
            self.helper(root.right, currSum * 10 + root.right.val)
        