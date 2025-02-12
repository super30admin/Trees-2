# Problem 2 : Sum Root to Leaf Numbers
# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # Global variable to store the sum result
        answer = 0
        
        def preOrder(root: Optional[TreeNode], currSum: int) -> None:
            # in python need to declare that the answer in not local 
            nonlocal answer
            # base case if the root is null then return 
            if not root:
                return 0
            # Calculate the number for the current node
            currSum = currSum * 10 + root.val 
            # Check if the the node is leaf node
            if not root.left and not root.right:
                # if the node is leaf then calculate the sum of the number till now and store in the answer
                answer += currSum
            # recursively call the function for left sub tree
            preOrder(root.left, currSum)
            # recursively call the function for right sub tree
            preOrder(root.right, currSum)
        # call the function for the root
        preOrder(root, 0)
        return answer
        