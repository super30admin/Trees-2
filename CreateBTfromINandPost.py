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
        '''Time Complexity: O(n^2) ---- Because of the list slicing
        Space Complexity: O(n) Stack space'''
        #Edge case
        if len(postorder)==0:
            return None
        
        #Last element of the post order will be the root
        rootVal=postorder[-1]
        root=TreeNode(rootVal)
        rootIdx=-1
        
        #Find the root index in inorder
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx=i
                
        inorderLeft=inorder[:rootIdx]
        inorderRight=inorder[rootIdx+1:]
        
        postorderLeft=postorder[:len(inorderLeft)]
        postorderRight=postorder[len(inorderLeft):len(postorder)-1]
        
        
        root.left=self.buildTree(inorderLeft,postorderLeft )
        root.right=self.buildTree(inorderRight,postorderRight )
            
        return root
