#leet code= 106 
#time complexity =O(N)
#space complexity =O(N)
# Approach - postorder last value is the root. We will get the index using inoder. Anything to the left of inorder is left subtree, anything right of inoder list belongs to right subtree.



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        #edge case
        if len(inorder)==0: return None
        
        root=TreeNode(postorder[-1])
        index=inorder.index(postorder[-1])
        
        postleft=postorder[:index]
        postright=postorder[index:-1]
        inleft=inorder[:index]
        inright=inorder[index+1:]
        
        root.left=self.buildTree(inleft,postleft)
        root.right=self.buildTree(inright,postright)
        return root