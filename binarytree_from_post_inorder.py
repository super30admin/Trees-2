# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.hash_map = {value: idx for idx, value in enumerate(inorder)}
        self.idx = len(postorder) - 1
        return self.helper(postorder, 0, len(inorder) - 1)

    def helper(self, postorder, start, end):
        if start > end:
            return None

        root_val = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(root_val)

        rootIdx = self.hash_map[root_val]

        root.right = self.helper(postorder, rootIdx + 1, end)
        root.left = self.helper(postorder, start, rootIdx - 1)

        return root


# time complexity is O(n) where n is the number of elements in either preorder or inorder
# space complexity is O(n) where n is the number of elements in either preorder or inorder
