'''
Problem: Sum Root to Leaf Numbers
Time Complexity: O(n), where n is number of nodes
Space Complexity: O(h), for recursion stack, h is height of the tree
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        form number along the path
        if leaf node then add number to the sum
        recurse on left and right subtree
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def helper(curr, currsum):
            nonlocal total
            if curr:
                currsum = currsum * 10 + curr.val

                #if not (curr.left or curr.right):
                if curr.left is None and  curr.right is None:
                    total+=currsum
            
                helper(curr.left, currsum)
                helper(curr.right, currsum)

        total = 0
        helper(root, 0)
        return total