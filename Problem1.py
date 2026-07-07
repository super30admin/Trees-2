#Problem 106. CONSTRUCT BINARY TREE FROM INORDER AND POSTORDER TRAVERSAL
# TIME COMPELXITY: O(N) where N denotes the number of nodes ie the number of elements in a given array
# SPACE COMPLEXITY: O(N) where N denotes the number of elements that is being recursively being called to make a stack call


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
        :rtype: Optional[TreeNode]
        """
        self.index=len(postorder)-1
        inordermap={val:i for i,val in enumerate(inorder)}
        return self.helper(postorder,0,len(postorder)-1,inordermap)

    def helper(self,postorder,start,end,inordermap):
        if start>end:
            return None

        root=postorder[self.index]
        self.index=self.index-1
        rootIndex=inordermap[root]

        node=TreeNode(root)
        node.right=self.helper(postorder,rootIndex+1,end,inordermap)
        node.left=self.helper(postorder,start,rootIndex-1,inordermap)

        return node