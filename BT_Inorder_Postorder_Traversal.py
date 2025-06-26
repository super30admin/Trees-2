# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(n), due to recursion stack and hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Build a hashmap to store value -> index relations from inorder
        inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        self.post_idx = len(postorder) - 1  # Start from the last index in postorder

        def helper(left, right):
            if left > right:
                return None

            # Pick current root from postorder
            root_val = postorder[self.post_idx]
            self.post_idx -= 1
            root = TreeNode(root_val)

            # Build right subtree before left subtree
            index = inorder_index_map[root_val]
            root.right = helper(index + 1, right)
            root.left = helper(left, index - 1)

            return root

        return helper(0, len(inorder) - 1)
