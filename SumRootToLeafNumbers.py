# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexity -> O(n)
# Space complexity -> O(1)
class Solution:
    total = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        self.helper(root, 0)
        return self.total
        
    def helper(self,root, currSum):
        if not root:
            return
        
        self.helper(root.left, currSum*10+root.val)
        
        if root.left is None and root.right is None:
            self.total += currSum*10 + root.val
            return
        
        self.helper(root.right, currSum*10+root.val)