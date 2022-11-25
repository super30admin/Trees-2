#TC: O(n)
#SC: O(n)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        postorder_idx=len(postorder)
        inorder_val_idx_mp={val:i for i,val in enumerate(inorder)}
        def recurse(inorder_st,inorder_end):
            if inorder_st>inorder_end: return None
            
            nonlocal postorder_idx,inorder_val_idx_mp
            postorder_idx-=1
            cur_root_val=postorder[postorder_idx]
            inorder_idx=inorder_val_idx_mp[cur_root_val]
            right_st,left_st=recurse(inorder_idx+1,inorder_end),recurse(inorder_st,inorder_idx-1)
            return TreeNode(cur_root_val,left_st,right_st)

        
        return recurse(0,len(inorder)-1)