# // Time Complexity : O(n)
# // Space Complexity : O(H)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Recursion Approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    result = 0

    def sumNumbers(self, root: TreeNode) -> int:
        if root == 0:
            return 0
        self.helper(root, 0)
        return self.result

    def helper(self, root, curr_sum):
        # Base
        if root == None:
            return
        if root.left == None and root.right == None:
            self.result += curr_sum * 10 + root.val

        # Logic
        curr_sum = curr_sum * 10 + root.val
        self.helper(root.left, curr_sum)
        self.helper(root.right, curr_sum)


