#Time Complexity : O(n) 
# Space Complexity : O(h) where h is tree height for recursive stack 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.finalSum = 0
        def helper(root,currSum):
            if root is None:
                return
            if (root.left is None and root.right is None):
                self.finalSum = self.finalSum + currSum * 10 + root.val
                return 
            helper(root.left,currSum * 10 + root.val)
            helper(root.right,currSum * 10 + root.val)

        helper(root,0)
        return self.finalSum