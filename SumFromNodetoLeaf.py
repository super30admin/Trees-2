#Time complexity: O(n)
#Space complexity: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    sum1=0
    def sumNumbers(self, root) -> int:
        self.sum1=0
        self.helper(root,0)
        return self.sum1
    def helper(self,root,currentSum):
        if root == None:
            return 0
        if not root.left and not root.right:
            self.sum1+=(currentSum*10)+root.val
        self.helper(root.left, currentSum*10 + root.val)
        self.helper(root.right, currentSum*10 + root.val)
        
        