# // Time Complexity : o(n^2)
# // Space Complexity :o(n^2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :None
#
#
# // Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(inorder) * len(postorder) == 0:
            return None
        root = TreeNode(postorder[-1])

        i = inorder.index(root.val)

        root.left = self.buildTree(inorder[:i], postorder[:i])
        root.right = self.buildTree(inorder[i + 1:], postorder[i:-1])

        return root