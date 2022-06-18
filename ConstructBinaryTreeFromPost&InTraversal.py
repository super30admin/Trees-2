#TC: O(n^2)
# Definition for a binary tree node.
class TreeNode(object):
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if len(postorder)==0: return None
        rootVal=postorder[-1]
        rootIdx=-1
        root=TreeNode(rootVal)
        for i in range(0,len(inorder)):
            if inorder[i]==rootVal:
                rootIdx=i
                break
        inLeft=inorder[:rootIdx]
        inRight=inorder[rootIdx+1:]
        postLeft=postorder[:rootIdx]
        postRight=postorder[rootIdx:-1]
        root.left=self.buildTree(inLeft, postLeft)
        root.right=self.buildTree(inRight, postRight)
        return root
        