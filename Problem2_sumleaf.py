'''
Time Complexity : O(n)
Space Complexity : O(n)
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def sum_helper(root):
            if not root:
                return []
            # base case
            # check for leaf
            if not (root.left or root.right):
                # returning (value, exponent) pair
                return [(root.val, 1)]

            left = sum_helper(root.left)
            right = sum_helper(root.right)

            res = []
            for value, exp in left:
                res.append(((root.val * (10 ** exp)) + value, exp + 1))

            for value, exp in right:
                res.append(((root.val * (10 ** exp)) + value, exp + 1))

            return res

        resp = sum_helper(root)

        return sum([value for value, _ in resp])