# Leetcode 106. Construct Binary Tree from Inorder and Postorder Traversal

# Time Complexity :  O(n) where n is the number of the nodes in tree

# Space Complexity : O(n) where n is the number of the nodes in tree thath can be in the stack in worst case

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: start at the root and traverse down the tree on the left child. Append the root to stack at
# every level of the tree. Once we reach the leaf, we check for its children and we exit out of the inner
# while i.e. we reached the left leaf. Now pop the stack and use the element as root. Check if there is a
# previous node and if its val is greater than root. If its greater than return false as that is not possible
# in a valid BST. Now traverse the right child. Once all the nodes are travsersed and stack is empty, return
# True

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
    index = None

    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.index = len(postorder)-1
        # base
        if len(postorder) == 0 and len(inorder) == 0:
            return None
        # Filling the hashmap using inorder
        for i in range(len(inorder)):
            self.mapp[inorder[i]] = i
        # helper function call with start and ending indices for sub trees
        return self.helper(postorder, inorder, 0, len(inorder)-1)

    def helper(self, postorder, inorder, start, end):
        # base
        # When pointer on postorder reaches start of the array or start and end indices meet
        if self.index == -1 or start > end:
            return None

        # Logic
        # Using postorder and a pointer to find rootIndex at every step
        rootIndex = self.mapp[postorder[self.index]]
        # Using to rootIndex to find the root node from Inorder
        root = TreeNode(inorder[rootIndex])
        # Incrementing the index to find next root node index from postorder
        self.index -= 1
        # recurssive call for right sub tree
        root.right = self.helper(postorder, inorder, rootIndex+1, end)
        # recurssive call for left sub tree
        root.left = self.helper(postorder, inorder, start, rootIndex-1)

        return root
