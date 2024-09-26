"""

    Student : Shahreen Shahjahan Psyche
    Time :  O(N)
    Space: O(H) -> Stack Space

    This code ran successfully for all the test cases in Leetcode

"""

# Definition for a binary tree node.
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        # edge case
        if not inorder or not postorder:
            return None
        
        inorderSet = {}
        # saving my inorder values and its index as key value pair for better efficiency
        for i in range(len(inorder)):
            inorderSet[inorder[i]] = i
            
        # building the tree
        def find_tree(inorder, postorder, start, end, inorderSet):
            
            # my index value as not binded in local
            nonlocal index
            
            # edge case
            if start > end or index == -1:
                return
            
            # creating the root
            root = TreeNode(postorder[index])
            # finding the position in inorder
            ind = inorderSet[root.val]
            # as we are dealing with postorder, our root will be from the left.
            index -= 1
            
            # again, as we are using postorder, first I will eencounter the right child, then left
            root.right = find_tree(inorder, postorder, ind + 1, end , inorderSet)
            root.left = find_tree(inorder, postorder, start, ind - 1, inorderSet)
            
            return root
        
        # root starts from the last index of postorder
        index = len(postorder)-1
        return find_tree(inorder, postorder, 0, len(inorder)-1, inorderSet)
            
            
            
        