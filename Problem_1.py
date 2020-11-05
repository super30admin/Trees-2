"""
Time Complexity : O(n) as we go through the inorder and store the indexes and then again iterate through all the
elements one
Space Complexity : O(n) as we are storing n values in a dictionary 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
This is similar to the problem where we need to construct binary tree from inorder and preorder.
Firstly, we did a solution, wherein at every point, I was sending a copy of inorder array to the 
recursive method. But that is very time consuming, O(n^2) as first we find index of a value and at every 
value, we are making array copis and passing. It is expensive space wise as well as we are making array copies
at every point. So, in another approach, we make a hashmap storing index of values from an inorder array
which makes fetching the index O(1). Then, we only pass the index of start and ending position from inorder
array and modify the index from postorder array to iterate through all of them once. This increased the
efficiency exponentially.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):
    def buildTree(self, inorder, postorder):
        self.d = {}
        for i in range(len(inorder)):
            self.d[inorder[i]] = i
        global idpre
        idpre = len(postorder)-1
        return self.helper(0, len(inorder), inorder, postorder)

    def helper(self, start, end, inorder, postorder):
        global idpre
        if start >= end:
            return
        value = postorder[idpre]
        index = self.d[value]
        root = TreeNode(value)
        idpre -= 1
        root.right = self.helper(index+1, end, inorder, postorder)
        root.left = self.helper(start, index, inorder, postorder)
        return root


# class Solution(object):
#     def buildTree(self, inorder,postorder):
#         if inorder:
#             idx=inorder.index(postorder.pop())
#             root=TreeNode(inorder[idx])
#             root.right= self.buildTree(inorder[idx+1:],postorder)
#             root.left= self.buildTree(inorder[:idx],postorder)
#             return root
