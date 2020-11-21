# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexity - O(n) since it visits all the nodes in the tree
# Space complexity - O(2h) recursive stack space (2h since we are also keeping previous values)
# Did this solution run on leetcode? - yes
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        # edge case
        if not root:
            return 0
        
        self.node_sum = 0
        
        # logic
        def rec(node, prev):
            prev = prev * 10 + node.val
            if not (node.left or node.right):
                self.node_sum += prev
            
            if node.left:
                rec(node.left, prev)
            
            if node.right:
                rec(node.right, prev)
                 
                    
        rec(root, 0)
        return self.node_sum


# Iterative solution
# Time complexity - O(n) 
# Space complexity - O(2h) 
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        # edge case
        if not root:
            return 0
        self.node_sum = 0
        nodes = deque([(root, 0)])
        while nodes:
            curr, prev = nodes.pop()
            prev = prev * 10 + curr.val
            if not (curr.left or curr.right):
                self.node_sum += prev
            if curr.left:
                nodes.append((curr.left, prev))
            if curr.right:
                nodes.append((curr.right, prev))
        return self.node_sum
                

# inorder
# Time complexity - O(n) 
# Space complexity - O(2h) 
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        # edge case
        if not root:
            return 0
        
        # logic
        self.node_sum = 0
        prev = 0
        nodes = deque()
        while nodes or root:
            while root:
                prev = prev * 10 + root.val
                nodes.append((root, prev))
                root = root.left
            root, prev = nodes.pop() # stack - pop from the right
            if not (root.right or root.left):
                self.node_sum += prev
            root = root.right

        return self.node_sum
            
