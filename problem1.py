#  Time Complexity : O(n2)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this :no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not (inorder and postorder):
            return None
        rootval = postorder.pop()
        inleft = inorder[:inorder.index(rootval)]
        inright = inorder[inorder.index(rootval) + 1:]
        root = TreeNode(rootval)
        root.right = self.buildTree(inright, postorder)
        root.left = self.buildTree(inleft, postorder)
        return root