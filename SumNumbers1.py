# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity - o(n)
# Space Complexity - o(1)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def helper(node,acc):
            if node is None:
                return 0

            acc = acc*10 + node.val

            if node.left is None and node.right is None:
                return acc
            
            return helper(node.left,acc) + helper(node.right,acc)
        
        return helper(root,0)