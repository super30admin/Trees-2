"""
Trees-2
Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

Time Complexity : O(n)
Space Complexity : O(h) where h is the recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is to recursively call left sub tree and right sub tree along with multiplying the curr_sum with 10 and adding the curr
root value. when we complete the recursive calls add left tree sum and right tree sum and return it.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution: 
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        # pre order
        def dfs(root, curr_sum):
            if root is None:
                return

            if root.left is None and root.right is None:
                self.res_sum += curr_sum * 10 + root.val
            
            dfs(root.left, curr_sum * 10 + root.val)
            dfs(root.right, curr_sum * 10 + root.val)

        self.res_sum = 0
        dfs(root, 0)
        return self.res_sum
        
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        # inorder
        def dfs(root, curr_sum):
            if root is None:
                return
            
            dfs(root.left, curr_sum * 10 + root.val)
            if root.left is None and root.right is None:
                self.res_sum += curr_sum * 10 + root.val
            dfs(root.right, curr_sum * 10 + root.val)

        self.res_sum = 0
        dfs(root, 0)
        return self.res_sum
        
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        # post order
        def dfs(root, curr_sum):
            if root is None:
                return
            
            dfs(root.left, curr_sum * 10 + root.val)
            dfs(root.right, curr_sum * 10 + root.val)
            if root.left is None and root.right is None:
                self.res_sum += curr_sum * 10 + root.val

        self.res_sum = 0
        dfs(root, 0)
        return self.res_sum

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        # return method integer
        def dfs(root, curr_sum):
            if root is None:
                return 0
            
            case1 = dfs(root.left, curr_sum * 10 + root.val)
            case2 = dfs(root.right, curr_sum * 10 + root.val)
            if root.left is None and root.right is None:
                curr_sum = curr_sum * 10 + root.val
                return curr_sum

            return case1 + case2

        self.res_sum = 0
        return dfs(root, 0)

# Iterative solution
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        stack = []
        res_sum = 0
        num = 0
        while root is not None or len(stack) != 0:
            while root is not None:
                num = num * 10 + root.val
                stack.append((root, num))
                root = root.left
            root, num = stack.pop()
            if root.left is None and root.right is None:
                res_sum += num
            root = root.right
        
        return res_sum
                            