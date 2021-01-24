#Time Complexity:O(n)
#Space Complexity:O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    dict ={}                                                                        #declaring a hash map
    idx=-1
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(postorder)==0:                                                       #Checking if input is empty
            return None
        for i in range(len(inorder)):                                               # initializing values in hashmap using the inorder array
            self.dict[inorder[i]]=i
        self.idx=len(postorder)-1
        return self.helper(postorder,0,len(inorder)-1)
    
    def helper(self,postorder: List[int], start:int, end:int) -> TreeNode:
        if start>end:                                                               #if start is grater than end then return
            return None
        rootVal=postorder[self.idx]                                                 #rootval will be assigned using the preorder at IDx'th index
        root=TreeNode(rootVal)                                                      #Creating the root node 
        self.idx-=1                                                                 #decrement the idx
        ridx=self.dict[rootVal]                                                     #obtain the rootval index from hashmap to find left and right subtrees
        root.right=self.helper(postorder,ridx+1,end)                                #Create right subtree
        root.left=self.helper(postorder,start,ridx-1)                               #Create left subtree
        return root                                                                 #return the final tree formed.
       