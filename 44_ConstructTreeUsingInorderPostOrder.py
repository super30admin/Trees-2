# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, inorder, postorder) -> TreeNode:
        # edge case
        if len(postorder) == 0:
            return None
        n = len(postorder)
        root = TreeNode(postorder[n - 1])
        index = -1
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                index = i
                break
        postLeft = postorder[0:index]
        postRight = postorder[index:n - 1]
        inLeft = inorder[0:index]
        inRight = inorder[index + 1:len(inorder)]

        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)

        return root