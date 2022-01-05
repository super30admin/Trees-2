# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time: O(nodes)
# Space: O(nodes)
class Solution(object):
    def __init__(self):
        self.p = 0
    def buildTree(self, inorder, preorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        dic = {}
        self.p = len(preorder) - 1
        for ind in range(len(inorder)):
            dic[inorder[ind]] = ind
        return self.rec(preorder, 0, len(inorder)-1, dic)
        
    def rec(self, preorder, s, e, dic):
        if s>e or self.p < 0:
            return None
        inorderIndex = dic[preorder[self.p]]
        root = TreeNode(preorder[self.p])
        self.p -= 1
        root.right = self.rec(preorder, inorderIndex+1, e, dic)
        root.left = self.rec(preorder, s, inorderIndex-1, dic)
        return root
            
        
        
