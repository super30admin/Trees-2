# Time Complexity : O(n)
# Space Complexity : O(h) where h is height of tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Your code here along with comments explaining your approach
# at every recursive level, the current node will be the root node starting there,
# so set it as root node, recursively call, leftsubtree and rightsubtree by changing
# inorder and postorder lists and assign them to root.left and root.right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # get root node
        if postorder == []:
            return
        root = postorder[-1]
        rootNode = TreeNode()
        rootNode.val = root
        rootin = inorder.index(root)
        # left subtree inorder - inorder[:rootin]
        # right subtree inorder - inorder[rootin+1:]
        # left postorder - postorder[:len(inorder[:rootin])]
        # right postorder - postorder[len(inorder[:rootin]):-1]
        rootNode.left = self.buildTree(inorder[:rootin],postorder[:len(inorder[:rootin])])
        rootNode.right = self.buildTree(inorder[rootin+1:],postorder[len(inorder[:rootin]):-1])
        return rootNode
