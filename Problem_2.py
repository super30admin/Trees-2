# Sum Root to Leaf Numbers

# Time Complexity : O(N)
# Space Complexity : O(H) H is height of Tree
# Did this code successfully run on Leetcode : Yes with Runtime: 32 ms and Memory Usage: 14.3 MB
# Any problem you faced while coding this : After Class No
# Your code here along with comments explaining your approach :
# Approach
"""
Using Recursive approach and following Depth First Search-Preorder
Traversal a number is constructed and formed by nodes in the same sub tree having
common digits and than backtracking to go to another sub-tree. 

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        def helper(node,curr_number=0): # Edge Cases
            if not node:
                return 0
            curr_number=curr_number*10+node.val
            if not node.left and not node.right:
                return curr_number
            return (helper(node.left,curr_number)+helper(node.right,curr_number))
        return helper(root)