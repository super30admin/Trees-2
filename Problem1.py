# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name:  Construct Binary Tree from Inorder and Postorder Traversal

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.smap = {val:idx for idx, val in enumerate(inorder)}
        self.idx = len(postorder) - 1
        return self.helper(postorder, len(postorder) - 1, 0)

    def helper(self, postorder, end, start):
        if start > end:
            return None
        rootVal = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(rootVal)
        rootIdx = self.smap[rootVal]
        root.right = self.helper(postorder, end, rootIdx + 1)
        root.left = self.helper(postorder,rootIdx - 1, start)

        return root