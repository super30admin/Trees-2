# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if (not inorder) or (not postorder):
            return None
        root = postorder[-1]
        inorder_root = inorder.index(root)
        left_inorder = inorder[:inorder_root]
        right_inorder = inorder[inorder_root + 1:]
        left_postorder = postorder[:inorder_root]
        right_postorder = postorder[inorder_root:-1]
        root = TreeNode(root)
        root.left = self.buildTree(left_inorder, left_postorder)
        root.right = self.buildTree(right_inorder, right_postorder)
        return root