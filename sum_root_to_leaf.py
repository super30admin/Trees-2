"""
Number from root to leaf can be formed by already available number * 10 + current number.
Preorder traversal that is process the current node and then move to left and right.
Approach1: recursion function does not return the ans, there is one local variable to make the number and one global
variable to keep track of total.
Approach2: recursion function returns the ans. In this case, global variable is not required, both will be local
Case study:
(1) the "if not node" base condition is required for the case when a node has one right child and no left child.
(2) num = num * 10 + node.val or node processing can be done before checking leaf node or after checking leaf node.
If done after checking leaf node, then the base case form the number again
(3) what if node processing is passed as parameters?

TC: O(n) and SC: O(h)
"""

# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def recursion_with_return(self, node, num, total):

        # base case
        if not node:
            return 0

        # recurse
        num = num * 10 + node.val  # already available number * 10 + current number

        if not node.left and not node.right:
            total += num
            return total

        left = self.recursion_with_return(node.right, num, total)
        right = self.recursion_with_return(node.left, num, total)

        return left + right

    def recursion_without_return(self, node, num, ans):

        # base case
        if not node:
            return

            # recurse
        num = num * 10 + node.val  # already available number * 10 + current number

        if not node.left and not node.right:
            ans[0] += num

        self.recursion_without_return(node.left, num, ans)
        self.recursion_without_return(node.right, num, ans)

    def helper(self, node, num, total):

        # base case
        if not node:
            return 0

        # recurse
        num = num * 10 + node.val  # number is formed

        left = self.helper(node.right, num, total)

        if not node.left and not node.right: # Checking is done in in-order way. It would work in post-order also
            total += num
            return total

        right = self.helper(node.left, num, total)

        return left + right

    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        ans = [0]
        self.recursion_without_return(root, 0, ans)
        return ans[0]