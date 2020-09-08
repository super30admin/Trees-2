#Time Complexity : O(nlogn) where n is the number of elements in preorder array, Did not get why
#Space Complexity : O(n) Did not get why
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach

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
        if len(postorder)==0:
            return None
        
        root=TreeNode(postorder[-1])
        index=-1
        for i in range(len(inorder)):
            if inorder[i]==root.val:
                index=i
                break
        
        root.left=self.buildTree(inorder[0:index],postorder[0:index])
        root.right=self.buildTree(inorder[index+1:],postorder[index:-1])
        
        return root