# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 
        
class Solution:
    # def buildTree(self,inorder,postorder):
    #     if not inorder or not postorder:
    #         return None 
    #     root = Node(postorder.pop())
    #     indx = inorder.index(root.val)
    #     root.right = self.buildTree(inorder[indx+1:],postorder)
    #     root.left = self.buildTree(inorder[:indx],postorder)
    #     return root 

    d = {}
    index = -1
    def buildTree(self, inorder, postorder):
        if not inorder or not postorder:
            return None 
        self.index = len(postorder)-1
        for i in range(len(inorder)):
            self.d[inorder[i]] = i 
        
        return self.helper(inorder,postorder,0,len(inorder)-1)
    
    def helper(self,inorder,postorder,start,end):
        # Base case 
        if self.index < 0 or start > end:
            return None 
        #Logic
        root = Node(postorder[self.index]) 
        self.index -= 1 
        indx = self.d[root.val]
        root.right = self.helper(inorder,postorder,indx+1,end)
        root.left = self.helper(inorder,postorder,start,indx-1)
        return root
    
if __name__ == "__main__":
    inorder = [9,3,15,20,7]
    postorder = [9,15,7,20,3]
    s = Solution()
    res = s.buildTree(inorder,postorder)
    print(res)
            