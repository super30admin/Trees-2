# Definition for a binary tree node.
from typing import List
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

# Time complexity: O(n)
# Space complexity: O(n)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def helper(in_left, in_right):
            nonlocal post_idx
            
            # Base case
            if in_left > in_right:
                return None
            
            # Choose the last element in postorder as root
            root_val = postorder[post_idx]
            root = TreeNode(root_val)
            
            # Decrement post_idx for next recursive call
            post_idx -= 1
            
            # Find the index of root in inorder
            root_idx = idx_map[root_val]
            
            # Recurse on right subtree
            root.right = helper(root_idx + 1, in_right)
            
            # Recurse on left subtree
            root.left = helper(in_left, root_idx - 1)
            
            return root
        
        
        idx_map = {val:idx for idx, val in enumerate(inorder)}
        

        post_idx = len(postorder) - 1
        

        return helper(0, len(inorder) - 1)
