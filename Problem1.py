class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        Time Complexity: O(n^2) in worst case when tree is skewed
        Space Complexity: O(h) where h is height of tree
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        if not inorder or not postorder:
            return None
        
        n = len(postorder) 
        root_val = postorder.pop()
        root = TreeNode(root_val)
        mid = inorder.index(root_val)
        root.right = self.buildTree(inorder[mid+1:], postorder)
        root.left = self.buildTree(inorder[:mid], postorder)
        return root 