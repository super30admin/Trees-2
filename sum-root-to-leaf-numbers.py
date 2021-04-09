# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(h), where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def sumNumbers(self, root: TreeNode) -> int:
        result = 0

        def helper(root, prevSum):

            if root is None:
                return

            currSum = prevSum * 10 + root.val

            if root.left is None and root.right is None:
                nonlocal result
                result += currSum
                return

            helper(root.left, currSum)
            helper(root.right, currSum)

        helper(root, 0)

        return result
