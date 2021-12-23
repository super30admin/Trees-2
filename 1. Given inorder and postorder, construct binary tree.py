class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # Time Complexity = O(n)
    # Space Complexity = O(1) as we're returning the new tree
    def buildTree(self, inorder, postorder):
        # If any of the arrays are none, then return None
        if not inorder or not postorder:
            return None

        # Last element of the preorder is always the root
        root = TreeNode(postorder.pop())

        # Find the index of the above root in inorder
        mid = inorder.index(root.val)

        # Recursively build left and right sub trees
        root.right = self.buildTree(inorder[mid + 1:], postorder)
        root.left = self.buildTree(inorder[:mid], postorder)
        return root
