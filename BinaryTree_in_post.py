
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes not able to come up with the iterative solution for this problem ,still need to work on this.


// Your code here along with comments explaining your approach

Given Inorder and postorder traversal we have to construct a binary tree.In post traversal the last element is the root element when found the index of the same element in inorder list we get the  left and right subtrees at that element.use recursion to build all the sub trees.In the end return the root.

Using Recursion

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# optimal solution using hash map
class Solution(object):
    def __init__(self):
        self.inorder_dict=dict()
        self.index=0
        
            
        
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        start=0
        self.index=len(inorder)-1
        end=len(inorder)-1
        if postorder==None or len(postorder)==0:
            return None
        for i in range(len(inorder)):
            self.inorder_dict[inorder[i]]=i
        return self.helper(inorder,postorder,start,end)

    def helper(self,inorder,postorder,start,end):
        if start>end or self.index<0:
            return None
        value=postorder[self.index]
        root=TreeNode(value)
        index=self.inorder_dict[value]
        self.index=self.index-1
        root.right=self.helper(inorder,postorder,index+1,end)
        root.left=self.helper(inorder,postorder,start,index-1)
        return root      
        
            
        
        