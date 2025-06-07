# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree (recursion stack), O(n) in worst case (skewed tree), O(log n) for balanced tree
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from collections import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        def helper(node, curr_sum):
            if not node:
                return 0
            
            curr_sum = curr_sum * 10 + node.val

            # If it's a leaf node, return the formed number
            if not node.left and not node.right:
                return curr_sum
            
            # Recursively sum from left and right subtrees
            left = helper(node.left, curr_sum)
            right = helper(node.right, curr_sum)

            return left + right

        return helper(root, 0)

# --------------------------------------------------------------------------------------

        #Iterative Approach
        # Time Complexity: O(n) — each node is visited once
        # Space Complexity: O(h) — stack can hold up to the tree height, O(n) worst case skewed, O(log n) balanced

        # if not root:
        #     return 0
        
        # stack = [(root, 0)]
        # total = 0

        # while stack:
        #     node, curr_sum = stack.pop()

        #     curr_sum = curr_sum * 10 + node.val

        #     if not node.left and not node.right:
        #         total += curr_sum

        #     if node.right:
        #         stack.append([node.right, curr_sum])
        #     if node.left:
        #         stack.append([node.left, curr_sum])

        # return total





