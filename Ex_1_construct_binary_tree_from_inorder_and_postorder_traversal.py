# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(n), for the hashmap and recursion stack in the worst case
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        
        # Optimized Approach using hashmap to store inorder indices
        indices = {}
        
        for idx, val in enumerate(inorder):
            indices[val] = idx

        self.post_idx = len(postorder) - 1  # Start from last index of postorder

        def dfs(l: int, r: int) -> Optional[TreeNode]:
            # Base case: invalid range
            if l > r:
                return None

            # Pick the current root from postorder traversal
            root_val = postorder[self.post_idx]
            self.post_idx -= 1

            # Create the root node
            root = TreeNode(root_val)

            # Get the index of the root in inorder to split subtrees
            idx = indices[root_val]

            # Important: Build right subtree first since postorder goes Left → Right → Root
            root.right = dfs(idx + 1, r)
            root.left = dfs(l, idx - 1)

            return root

        return dfs(0, len(inorder) - 1)

# --------------------------------------------------------------------------
        # Brute Force Approach
        # Time: O(n^2) due to slicing and .index() calls
        # Space: O(n^2) due to slicing and recursion stack

        # if not inorder or not postorder:
        #     return None
        #
        # root_val = postorder[-1]
        # root = TreeNode(root_val)
        # idx = inorder.index(root_val)
        #
        # root.left = self.buildTree(inorder[:idx], postorder[:idx])
        # root.right = self.buildTree(inorder[idx+1:], postorder[idx:-1])
        #
        # return root
