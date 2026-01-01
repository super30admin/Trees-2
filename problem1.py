"""
in postorder traversal, we see the position of root is at the end, so we use this and find the mid part though inorder and find left and right subtree, doing this recusively
helps us build left and right subtree by slicing the elements. 
TC is O(n^2) for the root and mid finding and then constructing the tree and SC is o(n^2) for same reasons
"""
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        if not inorder or not postorder:
            return None
        root = TreeNode(postorder[-1])
        mid = inorder.index(root.val)
        root.left = self.buildTree(inorder[:mid], postorder[:mid])
        root.right = self.buildTree(inorder[mid+1:], postorder[mid:-1])
        return root

        