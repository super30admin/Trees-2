# Leetcode 105. Construct Binary Tree from Preorder and Inorder Traversal

# Time Complexity :  O(n) where n is the number of the nodes in tree

# Space Complexity : O(n) where n is the number of the nodes in tree

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Find the root node index from preorder. Store inorder elements and indices in global Hmap.
# For root node from preorder use to find the root node position in inorder from the hashmap.
# Construct a new root node from that index and construct its left and right subtrees recursively by
# incrementing preorder index and using the start and end indices provided. start index to rootindex-1
# is left sub tree. rootindex + 1 to end is the right sub tree in inorder array

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # global hashmap to store inorder elements and their indices
    mapp = dict()
    # Pointer to find root index from pre order
    index = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        # base
        if len(preorder) == 0 and len(inorder) == 0:
            return None
        # Filling the hashmap using inorder
        for i in range(len(inorder)):
            self.mapp[inorder[i]] = i
        # helper function call with start and ending indices for sub trees
        return self.helper(preorder, inorder, 0, len(inorder)-1)

    def helper(self, preorder, inorder, start, end):
        # base
        # When pointer on pre order reaches end of the array or start and end indices meet
        if self.index == len(preorder) or start > end:
            return None

        # Logic
        # Using preorder and a pointer to find rootIndex at every step
        rootIndex = self.mapp[preorder[self.index]]
        # Using to rootIndex to find the root node from Inorder
        root = TreeNode(inorder[rootIndex])
        # Incrementing the index to find next root node index from preorder
        self.index += 1
        # recurssive call for left sub tree
        root.left = self.helper(preorder, inorder, start, rootIndex-1)
        # recurssive call for right sub tree
        root.right = self.helper(preorder, inorder, rootIndex+1, end)

        return root
