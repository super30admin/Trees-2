# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def sumNumbers(self, root: TreeNode) -> int:
            
        ## Recursive Approach
        result = 0
        def helper(node = root, path_sum = 0):
            
            ### Base Case
            if not node:
                return
            
            ### Logic
            
            # Update Sum
            path_sum = path_sum*10 + node.val
            
            # Add sum to global result when we reach leaf
            if not (node.left or node.right):
                nonlocal result
                result += path_sum
            
            # Recursively traverse Left
            helper(node.left, path_sum)
            
            # Recursively traverse Right
            helper(node.right, path_sum)
            
        helper()
        return result

### Complexity Analysis

# Time Complexity: O(N) --> N = Number of Nodes; We traverse through all the nodes
# Space Comlexity: O(H) --> H = Height of Tree; Stack Size occupied by recursive calls