# efinition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        """
        inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]



        """
        if not inorder or not postorder:
            return

        root_val = postorder[-1]
        root_val_pos = inorder.index(root_val)
        inleft = inorder[0:root_val_pos]
        inright = inorder[root_val_pos:]
        postleft = postorder[0:len(postorder)-len(inright)]
        postright = postorder[len(postorder)-len(inright):-1]

        root = TreeNode(root_val)
        root.left = self.buildTree(inleft, postleft)
        root.right = self.buildTree(inright, postright)

        return root
