# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not postorder or not inorder:
            return None

        root_val = postorder[-1]
        root = TreeNode(root_val)

        root_idx = inorder.index(root_val)

        inorder_left = inorder[:root_idx]
        inorder_right = inorder[root_idx + 1:]
        postorder_left = postorder[:root_idx]
        postorder_right = postorder[root_idx:-1]

        root.left = self.buildTree(inorder_left, postorder_left)
        root.right = self.buildTree(inorder_right, postorder_right)

        return root

        