# problem 1 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) == 0:
            return None
        root_val = postorder[-1]
        root_val_idx = -1
        for i in range(len(inorder)):
            if inorder[i] == root_val:
                root_val_idx = i
                break

        left_inorder = inorder[0:root_val_idx]
        right_inorder = inorder[root_val_idx+1:]

        left_postorder = postorder[0:len(left_inorder)]
        right_postorder = postorder[len(left_inorder):-1]

        node = TreeNode(root_val)
        node.left = self.buildTree(left_inorder,left_postorder)
        node.right = self.buildTree(right_inorder,right_postorder)

        return node