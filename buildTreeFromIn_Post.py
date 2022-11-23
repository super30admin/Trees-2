'''
Time Complexity -->

O(n)

Space Complexity -->
O(n^2) since we are creating array multiple times
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if inorder:
            index_val = inorder.index(postorder.pop(-1))
            root = TreeNode(inorder[index_val])
            root.right = self.buildTree(inorder[index_val+1:], postorder)
            root.left = self.buildTree(inorder[:index_val], postorder)
            return root
        