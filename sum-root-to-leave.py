'''
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
'''
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # lets have a helper function, and have a global result variable because I like it that way
        self.helper(root, 0)
        return self.result
    
    def helper(self, root, prev_value):
        # base case
        if root == None: return
        # logic
        prev_value = (prev_value*10) + root.val

        if root.left == None and root.right == None:
            self.result += prev_value
        # print(prev_value)
        self.helper(root.left, prev_value)
        self.helper(root.right, prev_value)

