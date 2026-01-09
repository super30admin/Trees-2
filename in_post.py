# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        if(len(postorder)==0):
            return None

        root_val = postorder[-1]
        root = TreeNode(root_val)

        root_index =0

        for i in range(len(inorder)):
            if inorder[i]==root_val:
                root_index = i
                break

        inorder_left = inorder[0:root_index]
        inorder_right =inorder[root_index+1:len(inorder)]

        postorder_left=postorder[0:len(inorder_left)]
        postorder_right=postorder[len(inorder_left):len(postorder)-1]

        root.left = self.buildTree(inorder_left, postorder_left)
        root.right = self.buildTree(inorder_right, postorder_right)

        return root

