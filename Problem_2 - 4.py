"""
Iterative Solution - BFS.
Time Complexity : O(n) where n is the number of nodes in the tree. 
Space Complexity : O(n).
    
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque 
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        q1 = deque()
        q2 = deque()
        q1.append(root)
        q2.append(root.val)
        result = 0 
        
        while q1:
            size = len(q1)
            
            for i in range(size):
                node = q1.popleft()
                cur_sum = q2.popleft()
                if not node.right and not node.left:
                    result += cur_sum
            
                if node.left:
                    q1.append(node.left)
                    q2.append(10*cur_sum + node.left.val)
            
                if node.right:
                    q1.append(node.right)
                    q2.append(10*cur_sum + node.right.val)
        
        return result 
            
                