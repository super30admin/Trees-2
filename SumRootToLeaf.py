# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity = O(n)
# Space Complexity = O(H) Height of the tree
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum1 = 0
        num = 0
        def helper(root: Optional[TreeNode], num: int):
            if not root:
                return
            if(root.left is None and root.right is None):
                self.sum1 = self.sum1 + (num*10+ root.val)
                return
            helper(root.left, num*10 + root.val)
            helper(root.right, num*10 + root.val)
        helper(root, num)
        return self.sum1
        