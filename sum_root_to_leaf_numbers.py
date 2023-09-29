# Time Complexity: O(n) where n is the number of nodes
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        self.helper(root, 0)
        return self.result
    def helper(self, root, currSum):
        if root.left == None and root.right == None:
            currSum = currSum * 10 + root.val
            self.result += currSum
            return
        if root.left:
            self.helper(root.left, currSum*10 + root.val)
        if root.right:
            self.helper(root.right, currSum * 10 + root.val)
