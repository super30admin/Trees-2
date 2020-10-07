"""
Author: Srinidhi
Did it run on LC: Yes
Time and Space Complexity: O(n) and O(n) resp.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder, postorder):
        map_inorder = {}
        for i, val in enumerate(inorder): map_inorder[val] = i
        def recur(low, high):
            if low > high: return None
            x = TreeNode(postorder.pop())
            mid = map_inorder[x.val]
            x.left = recur(low, mid-1)         # tyring to build left subtree first giving error
            x.right = recur(mid+1, high)
            return x
        return recur(0, len(inorder)-1)