# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder:
            return None

        # find root position
        root = TreeNode(postorder[-1])
        index = 0
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                index = i
                break

        root.left = self.buildTree(inorder[0:index], postorder[0:index])
        root.right = self.buildTree(inorder[index + 1:len(inorder)], postorder[index:len(postorder) - 1])

        return root
