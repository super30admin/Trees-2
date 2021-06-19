# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        :time complexity: O(n^2)
        :space complexity: O(n^2)
        """
        # # idea : zeroth index of pre order gives root node : root-->left-->right
        # # in order --> left-->root-->right
        if len(preorder)==0: return None
        root_index = 0
        root_val = preorder[0]
        root = TreeNode(root_val)
        for i in range(len(inorder)):
            if root_val == inorder[i]:
                root_index=i
        # Build four sub lists         
        pre_left = preorder[1:root_index+1]
        pre_right=preorder[root_index+1:len(preorder)]
        in_left=inorder[0:root_index]
        in_right=inorder[root_index+1:len(inorder)]
        root.left = self.buildTree(pre_left, in_left)
        root.right = self.buildTree(pre_right, in_right)
        return root
        
#         # shorter version
#         if not preorder or not inorder:
#             return None
#         root = TreeNode(preorder[0])
#         mid = inorder.index(preorder[0])
#         root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
#         root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
#         return root
    
    