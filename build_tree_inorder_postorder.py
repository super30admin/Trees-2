# Approach:
# The last element in postorder is the root of the current subtree. Use this root to find its index in the inorder list,
# which divides the tree into left and right subtrees. Recursively build the right subtree first (due to postorder's last-to-first traversal),
# then the left subtree, maintaining alignment with postorder traversal.

# Time Complexity: O(n), where n is the number of nodes, as we process each node once.
# Space Complexity: O(n), due to the recursive stack and the hashmap storing indices of inorder elements.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Hash map to store the index of each value in inorder for quick lookup
        inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        
        # Recursive helper function to build the tree
        def build_subtree(post_left, post_right, in_left, in_right):
            # Base case: if there are no elements to construct the tree
            if post_left > post_right:
                return None
            
            # The last element in postorder is the root for this subtree
            root_val = postorder[post_right]
            root = TreeNode(root_val)
            
            # Get the index of the root from inorder to split the tree
            in_root_index = inorder_index_map[root_val]
            
            # Calculate the size of the left subtree
            left_tree_size = in_root_index - in_left
            
            # Recursively construct the left and right subtrees
            root.left = build_subtree(post_left, post_left + left_tree_size - 1, in_left, in_root_index - 1)
            root.right = build_subtree(post_left + left_tree_size, post_right - 1, in_root_index + 1, in_right)
            
            return root
        
        # Build the tree using the helper function
        return build_subtree(0, len(postorder) - 1, 0, len(inorder) - 1)
