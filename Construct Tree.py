# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        if len(postorder) == 0:
            return
        temp = len(postorder)-1
        root = TreeNode(postorder[temp]) 
        for i in range(len(inorder)):
            if postorder[temp] == inorder[i]:
                idx = i
                break
        root.left = self.buildTree(inorder[:idx], postorder[:idx])
        root.right = self.buildTree(inorder[idx+1:], postorder[idx:temp])
        return root
        