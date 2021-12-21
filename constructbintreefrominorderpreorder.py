# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(inorder) == 0 or len(postorder) == 0:
            return None
        
        rootVal = postorder[-1]
        idx = -1
        root = TreeNode(rootVal)
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                idx = i
                break
        
        inleft = inorder[0:idx]
        inright = inorder[idx + 1:len(inorder)]
        postleft = postorder[0:idx]
        postright = postorder[idx:len(postorder) - 1]
        
        root.right = self.buildTree(inright, postright)
        root.left = self.buildTree(inleft, postleft)
        
        return root
        
        