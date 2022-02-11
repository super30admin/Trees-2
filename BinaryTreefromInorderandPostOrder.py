TC: O(N)
SC: O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if(postorder == None or len(postorder) == 0) : return None

        map = {}
        for i in range(len(inorder)):
            map[inorder[i]] =i
        idx =len(inorder)-1
        # print(idx)
       
        def helper(postorder:List[int], start:int , end:int):
            nonlocal idx
            # base
            if ( start>end) : return None
        
            rootVal = postorder[idx]
            idx-=1
            root = TreeNode(rootVal)
            # logic
            
            RootIdx = map[rootVal]
            root.right=helper(postorder,RootIdx+1,end)
            # The right recursion call should build before left
            root.left=helper(postorder,start,RootIdx-1)
         
            return root
            
        

      
        return helper(postorder,0,len(inorder)-1)
            
        
            
        
        