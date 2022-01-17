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
        if not inorder or not postorder:
            return None

        y = postorder.pop()
        output = ListNode(y)
        x = inorder.index(y)
        output.left = self.buildTree(inorder[:x], postorder[:x])
        output.right = self.buildTree(inorder[x+1:], postorder[x:])
        return output