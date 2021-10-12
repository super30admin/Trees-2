# Time complexity: O(n) where n is the number of elements in inorder and postorder array
# Space complexity: O(n)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, inorder, postorder):
        if len(inorder) == 0 or len(postorder) == 0:
            return
        nodeVal = postorder.pop()
        root = TreeNode(nodeVal)
        inorderIndex = inorder.index(nodeVal)
        root.right = self.buildTree(inorder[inorderIndex+1:], postorder)
        root.left = self.buildTree(inorder[:inorderIndex], postorder)
        return root
