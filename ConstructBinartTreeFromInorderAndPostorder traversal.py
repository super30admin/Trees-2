# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        # Inorder = Left Root Right
        #Postorder = Left Right Root
        # Time Complexity - O(N)
        # Space Complexity - O(N)
        
        self.inorder=inorder # Makin inorder global 
        self.postorder=postorder # Making postorder global
        self.post_idx = len(postorder)-1 #Global post_idx
        self.mp={} #map for storing index as value and inorder as key
        for idx in range(len(inorder)):
            self.mp[inorder[idx]]=idx
            
        return self.helper(0,len(inorder)-1)
    
    def helper(self,left,right):
        
        if left>right:
            return None
        value = self.postorder[self.post_idx]
        self.post_idx-=1
        root=TreeNode(value) #Last of postorder will be root
        index=self.mp[value]
        root.right=self.helper(index+1,right) # Index+1 till right will be to the right of the root 
        root.left=self.helper(left,index-1)# Left till index-1 will be to the left of the root
        
        return root