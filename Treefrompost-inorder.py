# TC: O(n); n is no.of nodes in tree
# SC: O(n^2)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(inorder) == 0:
            return
        
        n = postorder.pop()
        idx = inorder.index(n)
        root = TreeNode(n)
        root.right = self.buildTree(inorder[idx+1:],postorder)
        root.left = self.buildTree(inorder[:idx],postorder)
        return root
