# https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

class TreeNode:
    def __init__(self,value = 0, left = None, right = None):
        self.value = value
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder :list[int], postorder :list[int]):
        if not postorder:
            return None
        # finding the root- in postorder the sequence is left-> right -> root
        root_val = postorder[-1]
        # finding the index of the root in inorder list
        root_idx = inorder.index(root_val)
        # finding the left subtree
        in_left = inorder[:root_idx]
        # finding the right subtree
        in_right = inorder[root_idx+1:]
        # finding the left subtree in the postorder
        pre_left = postorder[0:len(in_left)]
        # finding the right subtree in the postorder
        pre_right = postorder[len(in_left): -1]


        # calling the TreeNode to create a new node in the tree
        root = TreeNode(root_val)
        # recursivly calling the function
        root.left = self.buildTree(in_left, pre_left)
        root.right = self.buildTree(in_right, pre_right)
        # return the root which is the pointer to all other nodes
        return root