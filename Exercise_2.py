# ## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
# // Time Complexity : O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root):
        self.total = 0
        self.helper(root, 0)
        return self.total

    def helper(self, root, curr_num):
        # base
        if root is None:
            return
        if (root.left is None and root.right is None):
            curr_num = curr_num * 10 + root.val
            self.total += curr_num
            return
        # logic

        self.helper(root.left, curr_num)
        self.helper(root.right, curr_num)


# int based recursion
# class Solution:
#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         return self.helper(root, 0)

#     def helper(self, root, curr_num):
#         # base
#         if root is None:
#             return 0
#         # logic
#         curr_num = curr_num * 10 + root.val
#         if (root.left is None and root.right is None):
#             return curr_num
#         left = self.helper(root.left, curr_num)
#         right = self.helper(root.right, curr_num)
#         return left + right
