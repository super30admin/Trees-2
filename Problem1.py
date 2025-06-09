"""
Implemented with reference to the homework solution.
Time Complexity: O(n)
Space Complexity: O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        
        def helper(in_start, in_end, post_start, post_end):
            if in_start > in_end or post_start > post_end:
                return None

            root_val = postorder[post_end]
            root = TreeNode(root_val)
            root_idx = inorder_map[root_val]

            left_tree_size = root_idx - in_start
            right_tree_size = in_end - root_idx

            root.left = helper(in_start, root_idx - 1, post_start, post_start + left_tree_size - 1)
            root.right = helper(root_idx + 1, in_end, post_end - right_tree_size, post_end - 1)

            return root

        return helper(0, len(inorder) - 1, 0, len(postorder) - 1)
        