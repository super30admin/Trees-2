# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        #iterative
        cur=0
        stack=[]
        sum1=0
        while(root!=None or len(stack)!=0):
            while(root!=None):
                cur=cur*10+root.val
                stack.append([root,cur])
                root=root.left
            root,cur=stack.pop()
            if root.left==None and root.right==None:
                sum1+=cur
            root=root.right
        return sum1
        #Time O(n)
        #Space O(h)
        
        
#         #Recursive
#         def traverse(node,cur):
#             if node:
#                 if node.left==None and node.right==None:
#                     self.store+=cur*10+node.val
#                 traverse(node.left,cur*10+node.val)
#                 traverse(node.right,cur*10+node.val)
    
#         self.store=0
#         traverse(root,0)
#         return self.store
#         #Time O(n)
#         #Space O(h)
