def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
    self.idx=len(postorder)-1
    inorder_map={val:i for i, val in enumerate(inorder)}
    return self.helper(postorder,0,len(inorder)-1,inorder_map)

def helper(self, postorder, start, end,inorder_map):
    if start>end:
        return
    root_val=postorder[self.idx]
    self.idx-=1
    root=TreeNode(root_val)
    root_idx=inorder_map[root.val]
    root.right=self.helper(postorder, root_idx+1,end,inorder_map)
    root.left=self.helper(postorder,start,root_idx-1, inorder_map)

    return root
    