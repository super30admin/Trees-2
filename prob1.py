# Time Complexity :O(n)
# Space Complexity :O(h) - height of tree
# Leet Code: Yes

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        if len(postorder) == 0:
            return None
        
        val = postorder[-1]
        root = TreeNode(val)
        for i in range(len(inorder)):
            if val == inorder[i]:
                break
        
        inorderleft = inorder[:i]
        inorderright = inorder[i+1:]
        postorderleft = postorder[:len(inorderleft)]
        postorderright = postorder[len(inorderleft) : len(inorder)-1]

        root.left = self.buildTree(inorderleft, postorderleft)
        root.right = self.buildTree(inorderright, postorderright)

        return root