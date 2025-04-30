# 106. Construct Binary Tree from Inorder and Postorder Traversal

# TC: O(n) where n is the number of nodes in the tree
# SC: O(n) for the hashmap and recursion stack
# Did this code successfully run on Leetcode: Yes
# Approach: 
# Root Identification: In postorder traversal, the last element is the root of the current tree/subtree (unlike preorder where it's the first element).
# Efficient Lookup: We create a hashmap to store the indices of values in the inorder array for O(1) lookup.
# Recursive Construction: The recursive helper function takes four parameters to define the current subtree ranges in both traversals:
    # in_start and in_end: the starting and ending indices of the current subtree in inorder array
    # post_start and post_end: the starting and ending indices of the current subtree in postorder array
# Partition Logic:
    # The root value is always the last element in the current postorder range
    # We find this root's position in inorder to divide elements into left and right subtrees
    # For the left subtree, we use elements before the root in inorder and the first portion of the postorder range
    # For the right subtree, we use elements after the root in inorder and the middle portion of the postorder range
# Base Case: When the inorder range becomes invalid (start > end), we return null.
# The time complexity is O(n) as we visit each node exactly once, and the space complexity is O(n) for the hashmap and recursion stack.

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Create a hashmap for O(1) lookups of value positions in inorder array
        inorder_map = {}
        for i, val in enumerate(inorder):
            inorder_map[val] = i
            
        # Function to recursively build the tree
        def build(in_start, in_end, post_start, post_end):
            # Base case: invalid range
            if in_start > in_end:
                return None
                
            # The last element in postorder array is the root of current subtree
            root_val = postorder[post_end]
            root = TreeNode(root_val)
            
            # Find position of root in inorder array
            root_idx = inorder_map[root_val]
            
            # Calculate size of left subtree
            left_size = root_idx - in_start
            
            # Recursively build left and right subtrees
            # Left subtree: elements before root in inorder
            # and corresponding elements at beginning of postorder
            root.left = build(in_start, root_idx - 1, post_start, post_start + left_size - 1)
            
            # Right subtree: elements after root in inorder
            # and corresponding elements before the root in postorder
            root.right = build(root_idx + 1, in_end, post_start + left_size, post_end - 1)
            
            return root
            
        # Start the recursive tree building process
        return build(0, len(inorder) - 1, 0, len(postorder) - 1)