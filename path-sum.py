# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    sum =  0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return sum
    def helper(self,root,countnum):
        if root is None:
            return
        currNum += currNum *10 

        self..helper(root.left, currNum)
        if root.left is None and root.right is None:
            Solution.sum += currNum

        self.helper(root.right,currNum)
    