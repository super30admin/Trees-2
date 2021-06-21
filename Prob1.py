#Time complexity: O(n)   
#Space complexity: O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        self.inorderDict = {}
        self.indexRoot = len(postorder)-1
        for idx,el in enumerate(inorder):
            self.inorderDict[el] = idx
        def helper(postorder,start,end):
            #base
            if start>end:
                return None
            #logic
            rootVal = postorder[self.indexRoot]
            self.indexRoot -=1
            root = TreeNode(rootVal)
            rootIdx = self.inorderDict[rootVal]
            root.right = helper(postorder,rootIdx+1,end)
            root.left = helper(postorder,start,rootIdx-1)
            return root
        return helper(postorder,0,len(inorder)-1)