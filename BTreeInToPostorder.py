""""// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.d = {}

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.Idx = len(postorder) - 1
        if len(postorder) == 0:
            return None
        for i in range(len(inorder)):
            self.d[inorder[i]] = i
        return self.helper(postorder, 0, len(postorder) - 1)

    def helper(self, postorder, start, end):
        if start > end:
            return None
        rootVal = postorder[self.Idx]
        self.Idx -= 1
        root = TreeNode(rootVal)
        rootIdx = self.d[rootVal]

        root.right = self.helper(postorder, rootIdx + 1, end)
        root.left = self.helper(postorder, start, rootIdx - 1)

        return root