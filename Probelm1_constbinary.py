'''
Time Complexity : O(n)
Space Complexity : O(n)
'''
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
        node = TreeNode(postorder[-1])
        mid = inorder.index(postorder[-1])
        node.left = self.buildTree(inorder[:mid],postorder[:mid])
        node.right = self.buildTree(inorder[mid+1:],postorder[mid:-1])
        return node