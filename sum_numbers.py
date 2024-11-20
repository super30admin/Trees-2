"Time and Space Complexity is O(N)"

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, current_sum):
            if not node:
                return 0
            
            # Update the current number by appending the node's value
            current_sum = current_sum * 10 + node.val
            
            # If it's a leaf node, return the current sum
            if not node.left and not node.right:
                return current_sum
            
            # Recurse on the left and right subtrees
            left_sum = dfs(node.left, current_sum)
            right_sum = dfs(node.right, current_sum)
            
            # Return the total sum from both subtrees
            return left_sum + right_sum
        
        return dfs(root, 0)
