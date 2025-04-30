# 129. Sum Root to Leaf Numbers

# TC: O(n) where n is the number of nodes in the tree
# SC: O(h) where h is the height of the tree (recursion stack)
# Did this code successfully run on Leetcode: Yes

# Approach: We use a recursive helper function to traverse the tree.
# For each node, we calculate the current running number by multiplying the previous sum by 10 (shifting left) and adding the current node's value.
# If we reach a leaf node (no left or right children), we return the current number as one complete root-to-leaf path.
# For non-leaf nodes, we recursively calculate the sum for both left and right subtrees and add them together.
# The final result is the total sum of all root-to-leaf numbers.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumNumbers(self, root):
        
        # Helper function to traverse the tree and calculate sum
        def helper(node, current_sum):
            # Base case: empty node
            if not node:
                return 0
            
            # Update current number by adding current digit
            # Formula: currentSum = currentSum * 10 + node.val
            current_sum = current_sum * 10 + node.val
            
            # If it's a leaf node, return the current number
            if not node.left and not node.right:
                return current_sum
            
            # Recursively calculate sum for left and right subtrees
            left_sum = helper(node.left, current_sum)
            right_sum = helper(node.right, current_sum)
            
            # Return sum of all paths
            return left_sum + right_sum
        
        # Start recursion with root node and initial sum 0
        return helper(root, 0)