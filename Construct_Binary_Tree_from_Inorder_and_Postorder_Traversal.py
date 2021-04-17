# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    inorder_dict = {}
    index = 0
    
    
    #Bruteforce
    
    def buildTree_bt(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        
        if not postorder or not inorder or (len(postorder) != len(inorder)):
            return

        root = TreeNode(postorder[-1])

        for i in range(len(inorder)):
            if inorder[i] == root.val:
                index = i
        #Preorder [3,9,20,15,7]
        leftpostorder =  postorder[:index]
        rightpostorder = postorder[index:-1]
        leftinorder = inorder[:index]
        rightinorder = inorder[index+1:]
        
        root.left = self.buildTree(leftinorder, leftpostorder )
        root.right = self.buildTree(rightinorder, rightpostorder)

        return root
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        
        if not postorder or not inorder or (len(postorder) != len(inorder)):
            return
        
        inorder_dict = {}
        Solution.index = len(postorder)-1
        
        
        for i in range(len(inorder)):
            Solution.inorder_dict[inorder[i]] = i
            
        print(Solution.inorder_dict)
        return self.helper(postorder,0,len(postorder)-1)
    
            
    def helper(self,postorder,start,end):
        
        #base
        if start > end:
            return
        
        #logic
        # root = TreeNode(postorder[Solution.index])
        # Solution.index -= 1
        root = TreeNode(postorder.pop())
        

        idx = Solution.inorder_dict[root.val]
        
        root.right = self.helper(postorder,idx+1,end)
        root.left = self.helper(postorder,start,idx-1)
        
        
        return root
        
