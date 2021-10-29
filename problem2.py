#time complexity O(n) space complexity O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
#Iterative apporach        
        if not root:
            return 0
        stack = [(0,root)]
        res=0
#Traversing in preorder        
        while stack:
            num,curnode = stack.pop()
            num =num*10+curnode.val
            
            if curnode.left:
                stack.append((num,curnode.left))
                
            if curnode.right:
                stack.append((num,curnode.right))
                
            elif not curnode.left and not curnode.right:
                res+=num
                
        return self.helper(root,0)
       


    
 #Recursive apporach using preorder traversal
    def helper(self,root,sum):
        if not root:
            return 0
        sum = sum*10+root.val
        
        if not root.left and not root.right:
            return sum
        
        return self.helper(root.left,sum)+self.helper(root.right,sum)
        
