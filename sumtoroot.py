# Time Complexity : O(N) where N is the number of nodes in the tree
# Space Complexity : O(h) where h is the recursion stack space maximum height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a helper with a dfs approach function to traverse the tree.
# The helper function takes two parameters - the current node and the current sum.
# If the current node is None, I am returning.
# If the current node is a leaf node, I am adding the current sum to the total sum.
# I am recursively calling the helper function for the left and right subtrees, updating the current sum accordingly.
# Finally, I am returning the total sum.

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.total = 0
        if not root:
            return 0
        def helper(root,sumy):
            if not root.left and not root.right:
                self.total += root.val+sumy*10
                return 
            if  root.left:
                helper(root.left,root.val+sumy*10)
            if  root.right:
                helper(root.right,root.val+sumy*10)
        helper(root,0)
        return self.total
        

        