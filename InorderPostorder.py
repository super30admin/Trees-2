# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Space Complexity - o(n)
# Time Complexity - o(n) 
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        idx = len(postorder)-1

        hashTb = {}
        n = len(inorder)
        for i in range(n):
            if inorder[i] not in hashTb:
                hashTb[inorder[i]] = i

        def helper(postorder,hashTb,s,e):
            nonlocal idx
            if s>e:
                return None

            root_val = postorder[idx]
            idx-=1
            root = TreeNode(root_val)
            in_idx = hashTb[root_val]
            
            root.right = helper(postorder,hashTb,in_idx+1,e)
            root.left = helper(postorder,hashTb,s,in_idx-1,)
            

            return root

        return helper(postorder,hashTb,0,n-1)