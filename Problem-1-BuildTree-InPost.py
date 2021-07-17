# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def buildTree(self, inorder, postorder) :
        current_head = 0

        if len(postorder) == 0:
            return None

        current_head = postorder[len(postorder) - 1]

        curr_node = TreeNode(current_head)

        curr_index = 0

        for i in range(len(inorder)):
            if inorder[i] == current_head:
                curr_index = i

        pl = postorder[0:curr_index]
        pr = postorder[curr_index: len(postorder) - 1]

        il = inorder[0: curr_index]
        ir = inorder[curr_index + 1: len(inorder)]

        curr_node.left = self.buildTree(il, pl)
        curr_node.right = self.buildTree(ir, pr)

        return curr_node

