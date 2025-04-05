# Time Complexity: O(n) where n is the number of nodes in the tree
# Space Complexity: O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# We observe that we need to get the current number at each node and add the current number to the result when we reach a leaf node.
# To achieve this, we multiply the current number with 10 and add the value at cuurent node to get the new current number.
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    res = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.res

    # recursive function to count the sum of number from root to leaf
    def helper(self, node, count):
        # base case
        if not node:
            return
        
        # updating count whenever we traverse a new node
        count = (count*10) + node.val
        # If the node we're currently at, a leaf node, we want to add the current number to the result
        if node.left == None and node.right == None:
            self.res += count

        # calling function recursively on the left sub-tree
        self.helper(node.left, count)
        # calling function recursively on the right sub-tree
        self.helper(node.right, count)