# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result=0
        self.helper(root,0)
        
        return self.result
    def helper(self, root: Optional[TreeNode],curr_sum:int):
        if root==None: return 
        self.helper(root.left, curr_sum*10+root.val )
        if root.left is None and root.right is None:
            self.result+=(curr_sum*10+root.val)
        self.helper(root.right,curr_sum*10+root.val)
        