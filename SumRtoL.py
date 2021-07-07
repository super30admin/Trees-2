//Time complexity-o(n)
//space complexity-o(h)
//Run on leetcode-yes

//DFS
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        return self.helper(root,0)
        
        
        
    
    def helper(self,node,val1):
        #base
        if not node:
            return 0
        if(node.left==None and node.right==None):
            return (val1*10) + node.val
        
        #logic
        case1 =self.helper(node.left,((val1*10)+node.val)) 
        case2=self.helper(node.right,((val1*10)+node.val))
        return case1+ case2
        
      ///BFS
      
      # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        q=[]
        q.append([root,0])
        sum=0
        while q:
            node,value=q.pop(0)
        
            if(node != None):
                value=value*10+node.val
                if(node.left==None and node.right==None):
                    sum+=value
                q.append([node.left,value])
                q.append([node.right,value])
        return sum
           
