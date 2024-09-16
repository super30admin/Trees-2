"""
Time complexity - O(N)
Space complexity - O(1)

Approach : save the left and right indices of the inorder and post order segments and follow similar 
approach as naive approach.

Runs on leet code

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
        
    inorder = []
    postorder = []
    def helper(self,inorder_l, inorder_r, postorder_l, postorder_r) :
        
        if postorder_r <= postorder_l :
            # len is 0 
            return None
        
        
        root_val = self.postorder[postorder_r - 1]
        
        root = TreeNode(root_val)

        for idx in range(inorder_l,inorder_r):
            if self.inorder[idx] == root_val :
                break
        
        inorder_l_l = inorder_l
        inorder_l_r = idx
        inorder_r_l = idx+1
        inorder_r_r = inorder_r

        postorder_l_l = postorder_l
        postorder_l_r = postorder_l+ (idx -inorder_l )
        postorder_r_l =  postorder_l + (idx- inorder_l)
        postorder_r_r =  postorder_r - 1
        
        l = self.helper(inorder_l_l,inorder_l_r,postorder_l_l,postorder_l_r)
        r = self.helper(inorder_r_l,inorder_r_r,postorder_r_l,postorder_r_r)
        
        root.left = l
        root.right = r
        return root
        
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.inorder = inorder
        self.postorder = postorder
        return self.helper(0,len(inorder),0,len(postorder))
        
