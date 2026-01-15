class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        map={}
        self.index=len(postorder)-1
        for i in range(len(inorder)):
            map[inorder[i]]=i
        return self.helper(postorder,0,len(inorder)-1,map)
    def helper(self,postorder,start,end,map):

        if start> end:
            return None
        
        root_val=postorder[self.index]
        self.index-=1
        root_idx=map[root_val]
        root=TreeNode(root_val)
        
        root.right=self.helper(postorder,root_idx+1,end,map)
        root.left=self.helper(postorder,start,root_idx-1,map)
        

        return root
        