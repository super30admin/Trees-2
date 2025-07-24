# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.index = len(postorder) - 1
        inorder_map = {val: i for i, val in enumerate(inorder)}
        return self.helper(postorder, 0, len(inorder) - 1, inorder_map)

    def helper(self, postorder, start, end, inorder_map):
        if start > end:
            return

        root_val = postorder[self.index]
        self.index -= 1
        root = TreeNode(root_val)
        root_index = inorder_map[root_val]

        root.right = self.helper(postorder, root_index + 1, end, inorder_map)
        root.left = self.helper(postorder, start, root_index - 1, inorder_map)
        return root