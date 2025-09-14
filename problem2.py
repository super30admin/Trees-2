# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
Space Complexity: O(H) where H is the height of the tree
Time Complexity: O(N)
"""
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.res = 0

        def rec(node, curr): 
            if node == None:
                return 
            curr = curr*10 + node.val

            if node.left == None and node.right == None: 
                self.res += curr

            rec(node.left, curr)
            rec(node.right, curr)
        rec(root, 0)
        return self.res
