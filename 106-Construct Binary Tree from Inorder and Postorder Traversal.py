class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not postorder or not inorder:
            return None
        
        root = TreeNode(postorder[-1])
        rootIndex = inorder.index(postorder[-1])
        
        root.left = self.buildTree(inorder[:rootIndex], postorder[:rootIndex])
        root.right = self.buildTree(inorder[rootIndex + 1:], postorder[rootIndex:-1])
        
        return root
    
# T.C => O(h) => Height of the tree
# S.C => O(n) => since we using recursive stack
# Approach => Here the last index of the post order traversal is the root.
#so we pass all the values from starting index till the root in in order as left tree and all the values from root till last as right tree. 
#Similary all the values in postorder till root is passed to left subtree and all the values from rootindex till -1 are passed as right sub tree in postorder