# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : elements to the left and right of root in inorder array are used to form the left and right subtree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def tree(left, right):
            if left > right:
                return None

            root_val = postorder.pop()
            root = TreeNode(root_val)

            root.right = tree(inorder_idx_map[root_val] + 1, right)
            root.left = tree(left, inorder_idx_map[root_val] - 1)

            return root

        inorder_idx_map = {}

        for idx, val in enumerate(inorder):
            inorder_idx_map[val] = idx

        return tree(0, len(postorder) - 1)