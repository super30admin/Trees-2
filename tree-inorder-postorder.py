'''
Time Complexity : O(n)
Space Complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        # inorder L root Right
        # postorder L right Root
        # preorder Root Left Right
        
        # Need to see solution to understand
        
        # root will be last of postorder
        inord = {}
        for k,v in enumerate(inorder):
            inord[v] = k
        i=len(postorder)-1
        def build(postorder,start,end):
            
            if(start>=end):
                return
            # root
            
            # can perform popleft or use a variable i in global scope
            #root_val = postorder.pop()
            
            nonlocal i
            root_val = postorder[i]
            root = TreeNode(root_val)
            subtree_ind  = inord[root_val]
            i-=1
            # left right root, root we have accessed, i-1 is right and then left
            # right subtree
            root.right = build(postorder,subtree_ind+1, end)
            # left subtree
            root.left = build(postorder,start, subtree_ind)
            
            return root
        return build(postorder, 0, len(postorder))
