# Time Complexity : O(n)
# Space Complexity : O(n) recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Have result as a global variable and currVal as a parameter as each Node will have its own current value and when its a leaf
# node then add the curr value to the global result.

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

    def helper(self, root, currVal):
        if not root:
            return None

        currVal = currVal * 10 + root.val
        if (root.left is None and root.right is None):
            self.result += currVal
        self.helper(root.left, currVal)
        self.helper(root.right, currVal)
