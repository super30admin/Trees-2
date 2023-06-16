"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(h) //h=height of the tree

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Last number in the postorder array is the root node of the tree
finding its index in the inorder array and dividing it into two halves
and recursively called those left and right halves to build the tree

"""

# Construct binary tree from inorder and postorder traversal

# Approach - 1

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
        if not inorder or not postorder:
            return None
        tree=TreeNode(postorder[-1])
        root=inorder.index(postorder[-1])

        tree.left=self.buildTree(inorder[0:root],postorder[0:root])
        tree.right=self.buildTree(inorder[root+1:],postorder[root:len(postorder)-1])


        return tree
    

# Approach - 2
# hamp - to reduce searching time of the root in postorder array to O(1)
# rootIdx pointer - to reduce the time of creating copies of postorder array


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def __init__(self):
        self.hmap={}
        self.idx=None
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder or not postorder:
            return None

        for i in range(len(inorder)):
            self.hmap[inorder[i]]=i
        

        self.idx=len(postorder)-1

        return self.helper(postorder,0,len(postorder)-1)

    def helper(self,postorder,start,end):

        if start>end or self.idx<0:
            return None

        rootVal=postorder[self.idx]
        root=TreeNode(rootVal)
        self.idx-=1
        rootIdx=self.hmap[rootVal]
        

        root.right=self.helper(postorder,rootIdx+1,end)
        root.left=self.helper(postorder,start,rootIdx-1)
        

        return root