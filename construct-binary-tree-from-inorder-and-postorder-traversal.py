# Time Complexity : O(n) - n is number of elements in inorder to populate the hashmap
# Space Complexity : O(n) - n is number of elements inorder list to add in the hashmap
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Find the index of root node from inorder list and then do recursion on the left subtree and right subtree
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """

        self.postorder_index = len(postorder)-1
        self.map = {}

        for i in range(0, len(inorder)):
            self.map[inorder[i]] = i

        return self.helper(postorder, 0, len(inorder) - 1)

    def helper(self, postorder, start, end):

        if start > end:
            return None

        root_val = postorder[self.postorder_index]
        root_index = self.map[root_val]
        root = TreeNode(root_val)
        self.postorder_index -= 1

        root.right = self.helper(postorder, root_index + 1, end)
        root.left = self.helper(postorder, start, root_index - 1)


        return root
