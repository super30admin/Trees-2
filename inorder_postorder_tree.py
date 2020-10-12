# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    idx = 0 
    h_map  = {}

    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        self.idx = len(postorder)-1
        for i in range(len(inorder)):
            self.h_map[inorder[i]]=i
        
        def helper(left,right):
            if left>right:
                return None
            val = postorder[self.idx]
            self.idx-=1
            index = self.h_map[val]
            root = TreeNode(val)
            root.right = helper(index+1,right)
            root.left = helper(left,index-1)
            return root
        return helper(0,len(inorder)-1)
        