# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity is O(n2), we are making n recursive calls, while copying a list in each call and searching for the index.
# Space Complexity is O(n2), we are making a copy of list in each recursive call.
# This can be optimized by using Hashmap to store indices.
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if(len(inorder) == 0):
            return None
        
        rootVal = postorder.pop()
        root = TreeNode(rootVal)
        
        index = inorder.index(rootVal)
        
        root.left = self.buildTree(inorder[:index],postorder[:index])
        root.right = self.buildTree(inorder[index+1:],postorder[index:])
        return root