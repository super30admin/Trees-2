# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:

        if not inorder or not postorder:
            return None
        root = TreeNode(postorder.pop())
        root.right = self.buildTree(inorder[inorder.index(root.val)+1:], postorder)
        root.left = self.buildTree(inorder[:inorder.index(root.val)], postorder)

        return root
        