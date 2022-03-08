# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        if(len(inorder) <=  0 or len(postorder) <= 0):
            return None
        root = TreeNode(postorder[-1])
        for i in range(0, len(inorder)):
            if(inorder[i] == postorder[-1]):
                leftInorder = inorder[0:i]
                rightInorder = inorder[i+1:]
                leftPostorder = postorder[0:i]
                rightPostorder = postorder[i:-1]

                root.left = self.buildTree(leftInorder, leftPostorder)
                root.right = self.buildTree(rightInorder, rightPostorder)
        return root
        