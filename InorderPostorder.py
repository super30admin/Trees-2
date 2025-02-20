# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        '''
        if not inorder:
            return None
        root = TreeNode(postorder.pop())

        idx = inorder.index(root.val). //O(n) finding the index
        root.right = self.buildTree(inorder[idx+1:],postorder) // here we are creating the subtree
        root.left = self.buildTree(inorder[:idx],postorder)

        return root
        '''
        # here we are creating the map 
        inorderdx = {v:i for i ,v in enumerate(inorder)}
        def helper(l,r):
            if(l>r):
                return None
            root = TreeNode(postorder.pop())
            idx = inorderdx[root.val]
            root.right = helper(idx+1,r)
            root.left = helper(l,idx-1)
            return root
        return helper (0,len(inorder)-1)



        