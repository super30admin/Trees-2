#LC 106 - Construct Binary Tree from Inorder and Postorder Traversal
#Time Complexity - O(n)
#Space Complexity - O(n)
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
        self.index = len(postorder) - 1
        self.d = {}
        for i in range(len(inorder)):
            self.d[inorder[i]] = i
        
        def helper(inorder, postorder,start,end):
            #base case
            if start > end or self.index < 0:
                return None
            root = TreeNode(postorder[self.index])
            self.index = self.index - 1
            inIdx = self.d[root.val]
            root.right = helper(inorder,postorder,inIdx+1,end)
            root.left = helper(inorder,postorder,start,inIdx-1)
            return root
        return helper(inorder,postorder,0,len(inorder)-1)