'''
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Iterate through the tree until you reach the leaf node, while iterating through till the leaf create the
number. Once you reach the leaf node add the number to the variable sum. Do this for left and right, return sum
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.sum = 0

    def helper(self, root: TreeNode, sum1: int, val: int) -> int:
        if root == None:
            self.sum = self.sum + 0
            return

        if root.left == None and root.right == None:
            self.sum = self.sum + ((val * 10) + root.val)
        else:
            self.helper(root.left, self.sum, (val * 10) + root.val)
            self.helper(root.right, self.sum, (val * 10) + root.val)

    def sumNumbers(self, root: TreeNode) -> int:
        result = 0
        self.helper(root, result, 0)
        return self.sum
