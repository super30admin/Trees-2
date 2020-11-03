# Time Complexity: O(n)
# Space Complexity: O(h) - height of tree
# Approach:
# Top down DFS - recursive preorder traverasal
# The dfs call processes every node first - accumulates the sum
# If you hit a leaf node, add the sum to the result
# Recursively process the right and left subtrees

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # Edge Case
        if not root:
            return 0
        
        # Use a mutable list as result (can be used as a global scope variable in python)
        result = [0]
        
        def dfs(node, slate):
            # Process node, add up the node value's in the slate            
            slate = slate * 10 + node.val
            
            # Leaf Node, accumulate result
            if node.left is None and node.right is None:
                result[0] += slate
            
            # Recursively process the left and right subtrees
            if node.left:
                dfs(node.left, slate)
            if node.right:
                dfs(node.right, slate)
                
            
            
        dfs(root, 0)
        return result[0]