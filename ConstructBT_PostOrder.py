#TC: O(n)
#SC: O(h)
#Don't start with Inorder array, form the logic from post or preorder and then use inorder array
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not postorder or not inorder:
            return None
        root= TreeNode(postorder[-1])
        mid=inorder.index(postorder[-1])
        root.left = self.buildTree(inorder[:mid],postorder[:mid])
        root.right = self.buildTree(inorder[mid+1:],postorder[mid:-1])
        return root
    
