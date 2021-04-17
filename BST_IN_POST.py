# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder or not postorder:
            return None
        def builder(in_start,in_end):
            nonlocal post_idx
            if in_start>in_end:
                return None
            elif(in_start==in_end):
                node=TreeNode(postorder[post_idx])
                post_idx-=1
                return node
            root_val= postorder[post_idx]
            root_idx=idx_map[root_val]
            root=TreeNode(root_val)
            post_idx-=1
            root.right=builder(root_idx+1,in_end)
            root.left=builder(in_start,root_idx-1)
            return root
        post_idx=len(postorder)-1
        idx_map={}
        for idx,val in enumerate(inorder):
            idx_map[val]=idx
        return builder(0,len(inorder)-1)