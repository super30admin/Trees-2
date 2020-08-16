# Time Complexity :O(n) where n is number of nodes
# Space Complexity : O(n) for the values in hashMap.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        # index of the last element in the postorder is root index
        self.index = len(postorder)-1

        self.d = {}
        for i in range(len(inorder)):
            self.d[inorder[i]] = i

        return self.helper(inorder, postorder, 0, len(inorder)-1)

    def helper(self, inorder: List[int], postorder: List[int], start, end):

        if start > end or self.index < 0:
            return None
        rootindex = self.d[postorder[self.index]]
        node = TreeNode(postorder[self.index])
        self.index -= 1
        node.right = self.helper(inorder, postorder, rootindex+1, end)
        node.left = self.helper(inorder, postorder, start, rootindex-1)

        return node

        #         if not inorder:
#             return

#         r=postorder.pop()
#         root=TreeNode(r)
#         i=inorder.index(r)

#         # i+1: from after index until the end of the list
#         root.right=self.buildTree(inorder[i+1:],postorder)
#         # :i from start until the index i
#         root.left=self.buildTree(inorder[:i],postorder)
#         return root
