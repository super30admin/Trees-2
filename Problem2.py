# Time Complexity: O(N)
# Space Complexity: O(N)
# Leetcode all test cases passed: Yes
# Any difficulties: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        num = []
        def helper(root, number):
            nonlocal num
            if root is None:
                return None
            number = number*10 + root.val
            if root.left is None and root.right is None:
                num.append(number)
                return
            helper(root.left, number)
            helper(root.right, number)
        helper(root, 0)
        return sum(num)
