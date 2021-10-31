#Time complexity O(n) and space complexity O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
 
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
 #Creating hashmap for storing indices of inorder       
        map={}
        self.p=len(postorder)-1
        for i in range(len(inorder)):
            map[inorder[i]]=i
            
        return self.helper(postorder,0,len(postorder)-1,map)

    #Creating the node according to the index value from inorder 
    def helper(self,postorder,s,e,map):
        
        if s>e:
            return None
        idx = map[postorder[self.p]]
        
        root = TreeNode(postorder[self.p])
        self.p-=1
        root.right = self.helper(postorder,idx+1,e,map)
        root.left = self.helper(postorder,s,idx-1,map)
        
        return root
