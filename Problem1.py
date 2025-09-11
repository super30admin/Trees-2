# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n)
    # sc : O(n+h)
    # ran successfully on leetcode
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        # postroder = left right root, inorder = left root right
        # the last index of postorder gives us the root 
        # find the root in the inorder , left of the rootindex is the left subtree an dthe right of rootinde to end is the right subtree
        # recurssively keep finding the root to create the binary tree

        # approach
        # store a map to for inorder to find the index of the root 
    
        hashmap = {val: idx for idx, val in enumerate(inorder)} # sc : O(n)

        root = self.helper(inorder, 0, len(inorder)-1, postorder, 0, len(postorder)-1, hashmap)

        return root

    
    def helper(self,inorder,instart, inend, postorder, poststart, postend, hashmap): # sc O(h) for recrussive stack

        # base
        if instart> inend or poststart > postend :
            return None

        # indexes
        root = TreeNode(postorder[postend]) # last element in the post order is our root

        root_index = hashmap[root.val]

        # leftsubtree size 
        lf_size = root_index - instart

        # in inorder the left subtree is from instart to the rootindex -1
        # in postorder the left subtree is from the poststart to the poststart + left size array -1(the left size array also includes the post start value, so we have to subtract 1 to equate)
        root.left = self.helper(inorder,instart, root_index -1, postorder,poststart, poststart+lf_size-1, hashmap)

        # in inorder the right subtree starts from root_index +1 to the end 
        # in postorder the right subtree starts from the postart + left array size and the end is moved one step to the left
        root.right = self.helper(inorder,root_index+1, inend, postorder,poststart+lf_size, postend-1, hashmap)

        return root





        