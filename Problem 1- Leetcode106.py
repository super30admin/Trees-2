#Time Complexity: O(n)
#Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        self.idx = len(postorder) - 1
        inorder_map = {val: i for i, val in enumerate(inorder)}
        return self.helper(postorder, 0, len(inorder) - 1, inorder_map)

    def helper(self, postorder, start, end, inorder_map):
        if start > end:
            return None

        root_val = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(root_val)

        root_idx = inorder_map[root_val]

        root.right = self.helper(postorder, root_idx + 1, end, inorder_map)
        root.left = self.helper(postorder, start, root_idx - 1, inorder_map)

        return root
        