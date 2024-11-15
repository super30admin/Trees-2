# Approach:
# We perform a depth-first search (DFS) traversal of the tree, keeping track of the current path value as we move down the tree.
# For each node, update the path value by shifting the previous path value by one decimal place and adding the current node’s value.
# When reaching a leaf, add the accumulated path value to the total sum, then return the final sum after traversing all paths.

# Time Complexity: O(n), where n is the number of nodes in the tree, as we visit each node once.
# Space Complexity: O(h), where h is the height of the tree, due to the recursive call stack.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # Helper function to perform DFS and calculate sum
        def dfs(node, path_sum):
            # If the node is None, return 0 as it doesn't contribute to the path
            if not node:
                return 0
            
            # Update path_sum by moving the previous sum one decimal left and adding the node's value
            path_sum = path_sum * 10 + node.val
            
            # Check if it's a leaf node
            if not node.left and not node.right:
                return path_sum  # Return the path_sum as it forms a complete number
            
            # Recursively calculate sum for left and right subtrees
            left_sum = dfs(node.left, path_sum)
            right_sum = dfs(node.right, path_sum)
            
            # Return the total sum from both subtrees
            return left_sum + right_sum
        
        # Initialize DFS with root node and path sum as 0
        return dfs(root, 0)
