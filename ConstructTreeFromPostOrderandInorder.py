# TC = O(n^2) --- where n is number of elements in the list
# SC= O(h) --- where h is the height of the tree


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) < 1 or len(inorder) < 1:
            return None

        n = len(postorder) - 1

        mid = inorder.index(postorder[n])  # O(n)
        root = TreeNode(postorder[n])
        root.left = self.buildTree(inorder[:mid], postorder[:mid])
        root.right = self.buildTree(inorder[mid + 1 :], postorder[mid:n])

        return root
