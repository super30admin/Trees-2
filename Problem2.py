## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        """
        Time Complexity: O(N)
        - We visit every node in the binary tree exactly once during our Depth-First Search (DFS).
        
        Space Complexity: O(H) 
        - H is the height of the tree, which represents the maximum depth of the recursion stack.
        - In the worst-case scenario (a skewed tree), this is O(N).
        - In the best-case scenario (a perfectly balanced tree), this is O(log N).
        """
        result = 0
        
        def helper(node, current):
            nonlocal result
            
            # Base case: if the current node is null, stop traversing this path
            if node == None:
                return
            
            # LOGIC: Build the number sequentially as we traverse deeper.
            # Shift the existing digits left (multiply by 10) and add the new digit.
            # E.g., for a path [1, 2, 3]:
            # Root (1): current = 0 * 10 + 1 = 1
            # Child (2): current = 1 * 10 + 2 = 12
            # Leaf (3): current = 12 * 10 + 3 = 123
            current = 10 * current + node.val
            
            # If both left and right children are None, we have reached a leaf node.
            # This means our path is complete, so we add the path's total to our global result.
            if node.left is None and node.right is None:
                result += current
            
            # Recursively call the helper on the left and right subtrees 
            # while passing down the current number formed so far.
            helper(node.left, current)
            helper(node.right, current)
            
        # Initialize the DFS traversal starting at the root with a current value of 0.
        helper(root, 0)
        
        return result