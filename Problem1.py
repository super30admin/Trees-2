# Time Complexity :O(n) where n is number of nodes
# Space Complexity :O(n)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 106


# Given inorder and postorder traversal of a tree, construct the binary tree.
#
# Note:
# You may assume that duplicates do not exist in the tree.
#
# For example, given
#
# inorder = [9,3,15,20,7]
# postorder = [9,15,7,20,3]
#
# Return the following binary tree:
#
#     3
#    / \
#   9  20
#     /  \
#    15   7

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):

    # Wrote a dictionary global dictionary which makes it easy to lookup the position in inorder array at any time in o(1)
    # Create a postIndex to just start from last and do -1 always.
    def __init__(self):
        self.mydict = {}
        self.postIndex = 0

    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # Takes 42 argumnents. Start and end are the array positions from where the inorder array should start and end.

        self.postIndex = len(postorder) - 1

        def helper(postorder, inorder, start, end):

            if start > end:
                return None
            if self.postIndex < 0:
                return

            root = TreeNode(postorder[self.postIndex])

            self.postIndex -= 1
            index = self.mydict[root.val]
            root.right = helper(postorder, inorder, index + 1, end)

            root.left = helper(postorder, inorder, start, index - 1)

            return root

        for index in range(len(inorder)):
            self.mydict[inorder[index]] = index
        return helper(postorder, inorder, 0, len(inorder) - 1)


inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
print(Solution().buildTree(inorder,postorder))