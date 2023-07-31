# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        Time complexity - O(n), n --> number of nodes
        Space - O(n) 
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # Create a hashmap to store the indices of elements in the inorder list
        inorder_map = {val: idx for idx, val in enumerate(inorder)}

        # Helper function to build the binary tree recursively
        def build(in_start, in_end, post_start, post_end):
            # Base case: If the start index is greater than the end index, return None
            if post_start > post_end:
                return None

            # Create a new node using the last element of postorder
            root_val = postorder[post_end]
            root = TreeNode(root_val)

            # Find the index of the root in the inorder list
            root_idx_inorder = inorder_map[root_val]

            # Calculate the number of elements in the right subtree
            right_subtree_size = in_end - root_idx_inorder

            # Recursively build the right subtree
            root.right = build(root_idx_inorder + 1, in_end,
                               post_end - right_subtree_size, post_end - 1)

            # Recursively build the left subtree
            root.left = build(in_start, root_idx_inorder - 1,
                              post_start, post_end - right_subtree_size - 1)

            return root

        # Call the helper function with the initial indices for inorder and postorder lists
        return build(0, len(inorder) - 1, 0, len(postorder) - 1)
