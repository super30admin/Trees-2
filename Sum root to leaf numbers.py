# TC-O(n)
# SC-O(height)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        self.sumi =0
        self.helper(root ,0)
        return self.sumi

    def helper(self ,node ,curr):
        if node is None:
            return
        curr =curr*10 +node.val
        if node.left is None and node.right is None:
            self.sumi+=curr
            return (self.sumi)



        self.helper(node.left ,curr)
        self.helper(node.right ,curr)