# Time Complexity: O(n)
# Space Complexity: O(n)
# Program ran on leetcode without any issues

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
        :rtype: TreeNode
        """
        n = len(inorder)
        inorderMap = {}
        for iX, eL in enumerate(inorder):
            inorderMap[eL] = iX

        postIx = n - 1
        return self.buildTreeHelper(0, n - 1, postorder, postIx, inorderMap)[0]
    
    
    def buildTreeHelper(self, strIx, endIx, postorder, postIx, inorderMap):
        if strIx > endIx:
            return None, postIx

        root = TreeNode(postorder[postIx])
        postIx -= 1
        inIx = inorderMap[root.val]
        

        root.right, postIx = self.buildTreeHelper(inIx + 1, endIx, postorder, postIx, inorderMap)

        root.left, postIx = self.buildTreeHelper(strIx, inIx - 1, postorder, postIx, inorderMap)

        return root, postIx