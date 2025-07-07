# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder:
            return None
        # find root in postorder
        n = len(postorder)
        rootval = postorder[-1]
        # create a new treeNode
        root = TreeNode(rootval)
        index = -1
        #find root in inorder
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                index = i
        # decide the left and right subtrees for recursion

        in_left = inorder[:index]
        in_right = inorder[index+1:]       #starting index in python is inclusionary
        post_left = postorder[:index]
        post_right = postorder[index:n-1]

        # let's recurse

        root.left = self.buildTree(in_left, post_left)
        root.right = self.buildTree(in_right, post_right)

        return root


        
        