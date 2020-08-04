# Time Complexity : O(n) where n is the number nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

#we recursively find root from postorder each time and get the left and right element from the inorder

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:

        if len(postorder) == 0:
            return

        root = TreeNode(postorder.pop())

        rootindx = -1

        for index, val in enumerate(inorder):

            if root.val == val:
                rootindx = index

        inleft = inorder[:rootindx]

        postleft = postorder[:rootindx]

        inright = inorder[rootindx + 1:]

        postright = postorder[rootindx:]

        root.left = self.buildTree(inleft, postleft)

        root.right = self.buildTree(inright, postright)

        return root


