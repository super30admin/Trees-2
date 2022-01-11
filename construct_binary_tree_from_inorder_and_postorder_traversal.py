class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:      
        if not inorder or postorder:
            return None
        root = TreeNode(postorder[-1])
        mid = inorder.index(postorder[-1])
        root.left = self.buildTree( inorder[:mid] , postorder[0:mid]  )
        root.right = self.buildTree( inorder[mid+1:] , postorder[ mid:-1 ]   )
        return root 
