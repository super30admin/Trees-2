class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        if inorder:
            
            r=postorder.pop() 
            root=TreeNode(r) 
            i=inorder.index(r) 
        
            root.right=self.buildTree(inorder[i+1:],postorder) 
            root.left=self.buildTree(inorder[:i],postorder) 
            return root
            
            
            ''' approach is similar to what was in contruct the tree from preorder and inorder except here last value in postored is the root.
                time ccocmplexity and space compexity is o(n).'''
