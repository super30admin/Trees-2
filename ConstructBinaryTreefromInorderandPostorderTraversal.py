# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder:
            return None
        root = TreeNode(postorder.pop())

        idx =-1
        for i,ele in enumerate(inorder):
            if ele==root.val:
                idx = i
                break
        root.right = self.buildTree(inorder[idx+1:],postorder)
        root.left =  self.buildTree(inorder[:idx],postorder)

        return root
        
        