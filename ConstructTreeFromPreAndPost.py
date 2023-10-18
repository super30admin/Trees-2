# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        if not inorder: return None
        root = TreeNode(preorder.pop(0))
        indexOfRoot = inorder.index(root.val)
        root.left = self.buildTree(preorder, inorder[0:indexOfRoot])
        root.right = self.buildTree(preorder, inorder[indexOfRoot + 1::])
        return root

