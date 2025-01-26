# Similar to preorder and inorder but here we traverse from the end for index on post order array and use that index in the inorder array
# TC: O(N)
# SC: O(N)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(inorder) == 0 and len(postorder) == 0:
            return None
        self.dic = {val: idx for idx, val in enumerate(inorder)}
        self.rootidx = len(postorder) - 1
        return self.createTree(postorder, 0, len(inorder) - 1)

    def createTree(self, postorder, start, end):
        if start > end:
            return None
        rootval = postorder[self.rootidx]
        self.rootidx -= 1
        root = TreeNode(rootval)
        inoidx = self.dic[rootval]
        root.right = self.createTree(postorder, inoidx + 1, end)
        root.left = self.createTree(postorder, start, inoidx - 1)

        return root