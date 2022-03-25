# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 0
        def helper(root,curr_sum =0):
            if root:
                if not root.left and not root.right:
                    self.ans += curr_sum*10 + root.val
                    return
                helper(root.left, curr_sum*10 + root.val)
                helper(root.right, curr_sum*10 + root.val)
            
        helper(root)
        return self.ans
        