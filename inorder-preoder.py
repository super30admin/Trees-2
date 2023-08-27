# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or postorder:
            return None
        value = postorder[-1]
        root = TreeNode(value)
        index = inorder.index(value)
        root.left = self.buildTree(inorder[:index],postoder[:index])
        root.right = self.buildTree(inorder[index+1:],postorder[index:-1])
        return root