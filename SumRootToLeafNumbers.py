# Time Complexity: O(n)
# Space Complexity: O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum = 0
        def helper(root, parentSum):
            if root == None:
                return
            if root.left == None and root.right == None:
                self.sum += (parentSum * 10) + root.val
                return
            if root.left:
                helper(root.left, parentSum * 10 + root.val)
            if root.right:
                helper(root.right, parentSum * 10 + root.val)
            
        helper(root, 0)
        return self.sum
