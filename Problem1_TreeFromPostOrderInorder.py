'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 106. 
# Given two integer arrays postorder and inorder where postorder is the postorder 
# traversal of a binary tree and inorder is the inorder traversal of the same 
# tree, construct and return the binary tree.

#-----------------
# Time Complexity: 
#-----------------
# O(N): Where N is the number of elements in inorder/postorder traversal array 
#       Need to iterate over each element exactly once. Also need to build
#       hashmap so complexity = 2N

#------------------
# Space Complexity: 
#------------------
# O(N): Hashmap auxiliary data structure required to store value and index
#       of inorder traversal for O(1) lookup. Else, time complexity becomes
#       O(N^2) 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  48 ms   (98.15 %ile)
# Space            :  18.3 MB (93.55 %ile)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        n = len(inorder)
        # Same map as the inorder + preorder variant
        self.inorder_map = {value: index for index, value in enumerate(inorder)}
        # We need to read the postorder array in reverse
        self.postorder_index = n-1
        # Call the helper with the main problem
        return self.buildTreeHelper(postorder, 0, n-1)
    
    def buildTreeHelper(self, postorder:List[int], low: int, high:int):
        if low > high:
            return None
        else:
            # Select an element from the postorder array - Starting from the end
            # and going left
            val = postorder[self.postorder_index]
            # Create node
            node = TreeNode(val)
            # Decrement the index to move left
            self.postorder_index -= 1
            
            # We need to build right side first. 
            # That's because the postorder array is such that
            # when we start from the end and iterate left,
            # we get root, then right element, then left.
            node.right = self.buildTreeHelper(postorder, \
                                              self.inorder_map[val]+1,\
                                              high)

            node.left = self.buildTreeHelper(postorder, \
                                             low, \
                                             self.inorder_map[val]-1)
            return node