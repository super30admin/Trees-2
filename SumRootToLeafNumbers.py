# Time Complexity: O(N), N is the number of nodes in the tree
# Space Complexity: O(H), where H is the number of recursive function calls in the stack
# O (log N) in best case where the tree is balanced and O(N) in the worst case where the tree is skewed
# Did this code successfully run on Leetcode: Yes


from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)
    
    def helper(self, root, prev):
        if root is None:
            return 0
        
        if root.left == None and root.right == None:
            return prev * 10 + root.val
        
        prev = prev * 10 + root.val

        left = self.helper(root.left, prev)

        right = self.helper(root.right, prev)

        return left + right