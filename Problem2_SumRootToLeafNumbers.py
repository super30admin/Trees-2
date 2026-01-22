# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(h) where h is the height of the tree (recursion stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use DFS to traverse from root to each leaf, building the number as we go down.
# At each node, multiply current sum by 10 and add node value to form the number.
# When reaching a leaf node, add the complete number to the total sum.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        total_sum = 0
        
        def dfs(node, current_sum):
            nonlocal total_sum
            
            if not node:
                return
            
            # Build the number: multiply by 10 and add current node value
            current_sum = current_sum * 10 + node.val
            
            # If it's a leaf node, add to total sum
            if not node.left and not node.right:
                total_sum += current_sum
                return
            
            # Recursively traverse left and right subtrees
            dfs(node.left, current_sum)
            dfs(node.right, current_sum)
        
        dfs(root, 0)
        return total_sum
