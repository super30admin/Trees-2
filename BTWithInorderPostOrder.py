## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    hashMap = dict()
    idx = 0
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx = len(postorder) - 1
        for i in range(len(inorder)):
            self.hashMap[inorder[i]] = i
        return self.helper(postorder, 0, len(inorder)-1)

    def helper(self, postorder: List[int], start: int, end: int) -> Optional[TreeNode]:
        if self.idx < 0 or start > end:
            return None
        rootVal = postorder[self.idx]
        self.idx -= 1
        rootIdx = self.hashMap[rootVal]
        root = TreeNode(rootVal)
        if start == end:
            return root
        root.right = self.helper(postorder, rootIdx + 1, end)
        root.left = self.helper(postorder, start, rootIdx - 1)
        
        return root

#Time and Space Complexity O(n)