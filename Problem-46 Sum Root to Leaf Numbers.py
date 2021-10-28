# 129. Sum Root to Leaf Numbers
# https://leetcode.com/problems/sum-root-to-leaf-numbers/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursive Approach
# Time complexiety: O(n)
# Space complexiety: O(n)
class Solution:
    def __init__(self):
        self.s = 0
        
    def _helper(self, root, num):
        if root:
            num = 10*num + root.val
            if root.left == None and root.right == None:
                self.s += num

            self._helper(root.left,num)
            self._helper(root.right,num)
    
    def sumNumbers(self, root) -> int:
        self._helper(root,0)
        return self.s

# Iterative Approach
# Time complexiety: O(n)
# Space complexiety: O(n)
class Solution:
    def sumNumbers(self, root) -> int:
        if not root:
            return 0
        
        stack = [(root,0)]
        s = 0
        
        while stack:
            root, n = stack.pop()
            n = n*10 + root.val
            
            if root.left == None and root.right == None:
                s += n
            
            if root.right:
                stack.append((root.right,n))
            if root.left:
                stack.append((root.left,n))
        return s