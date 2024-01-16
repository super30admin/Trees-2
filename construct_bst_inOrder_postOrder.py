""" Explanation: The approach is similar to constructing a bst from inorder and pre_order bst. To get the root this time however, the last
    element of the index is at post_order. Now we store that value in a variable and search for it in the inorder traversal since search
    in a hashmap is O(1).
    Time Complexcity: O(n)
    Space Complexcity: O(n)
    Code passed all cases on LC: Yes
"""

#Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """

    # Create a hashmap to store indices of elements in the inorder list
        inorder_map = {val: idx for idx, val in enumerate(inorder)}

        # Helper function for recursive construction
        def build_tree_helper(in_start, in_end, post_start, post_end):
            # Base case: Empty subtree
            if in_start > in_end or post_start > post_end:
                return None

            # The last element in postorder list is the root
            root_val = postorder[post_end]
            root = TreeNode(root_val)

            # Find the index of root in inorder list
            root_idx = inorder_map[root_val]

            # Recursively construct left and right subtrees
            root.left = build_tree_helper(in_start, root_idx - 1, post_start, post_start + root_idx - in_start - 1)
            root.right = build_tree_helper(root_idx + 1, in_end, post_start + root_idx - in_start, post_end - 1)

            return root

        # Call the helper function with initial parameters
        return build_tree_helper(0, len(inorder) - 1, 0, len(postorder) - 1)

        