# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    # idx = None
    def buildTree(self, inorder, postorder): #T.C->O(N), S.C->O(N)
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        self.idx = len(postorder) -1
        self.map = {}

        for i in range (len(inorder)):
            self.map[inorder[i]]=i

        return self.helper(postorder,0,len(postorder)-1)

    def helper(self,postorder,start,end):

        if(start>end):
            return None
        rootVal = postorder[self.idx]
        self.idx-=1
        rootIdx = self.map[rootVal]

        root = TreeNode(rootVal)



        root.right = self.helper(postorder,rootIdx+1,end)
        root.left = self.helper(postorder,start,rootIdx-1)

        return root