# // Time Complexity : O(n) where n is the number of nodes.
# // Space Complexity : O(h) where h is the height of the tree.
# // Did this code successfully run on Leetcode : Yes.
# // Any problem you faced while coding this : No.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum = 0
        def helper(root,parentSum):
            if root == None:
                return
            
            helper(root.left,parentSum * 10 + root.val)
            if root.left == None and root.right == None:
                self.sum += (parentSum *10) + root.val
                return
            helper(root.right,parentSum * 10 + root.val)
            
        helper(root,0)
        return self.sum
