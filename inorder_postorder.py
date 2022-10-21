#TC O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not (inorder and postorder):
            return None
        r_val = postorder.pop()
        left = inorder[:inorder.index(r_val)]
        right = inorder[inorder.index(r_val) + 1:]
        root = TreeNode(r_val)
        root.right = self.buildTree(right, postorder)
        root.left = self.buildTree(left, postorder)
        return root