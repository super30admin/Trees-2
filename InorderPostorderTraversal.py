#Time Complexity: O(N)
#Space Complexity: O(N)
"""
We're building the tree from the end of postorder, since the last element is always the root.
We find the root in the inorder array to split into left and right subtrees.
Recursively build right first, then left (since we’re moving backwards in postorder).

"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder, postorder):
        self.map = {}
        self.postOrderIdx = len(postorder) - 1

        for i in range(len(inorder)):
            self.map[inorder[i]] = i

        return self.helper(postorder, 0, len(inorder) - 1)

    def helper(self, postorder, start, end):
        if start > end:
            return None

        rootVal = postorder[self.postOrderIdx]
        rootIdx = self.map[rootVal]
        self.postOrderIdx -= 1

        node = TreeNode(rootVal)
        node.right = self.helper(postorder, rootIdx + 1, end)
        node.left = self.helper(postorder, start, rootIdx - 1)

        return node