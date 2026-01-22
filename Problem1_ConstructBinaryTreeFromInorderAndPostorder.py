# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(n) for the hashmap and recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use hashmap to store inorder indices for O(1) lookup, then recursively build tree.
# Last element in postorder is root, find its position in inorder to split into left and right subtrees.
# Recursively construct left subtree from left portion and right subtree from right portion of inorder.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Create hashmap for O(1) lookup of inorder indices
        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        post_idx = len(postorder) - 1  # Pointer for postorder array (start from end)
        
        def build(in_start, in_end):
            nonlocal post_idx
            
            # Base case: no more nodes to process
            if in_start > in_end:
                return None
            
            # Get root value from postorder (last element is root)
            root_val = postorder[post_idx]
            post_idx -= 1
            
            # Create root node
            root = TreeNode(root_val)
            
            # Find root position in inorder
            root_pos = inorder_map[root_val]
            
            # Important: Build right subtree first, then left subtree
            # This is because in postorder, we traverse from right to left
            # Right subtree: inorder[root_pos + 1 : in_end + 1]
            # Left subtree: inorder[in_start : root_pos]
            root.right = build(root_pos + 1, in_end)
            root.left = build(in_start, root_pos - 1)
            
            return root
        
        return build(0, len(inorder) - 1)
