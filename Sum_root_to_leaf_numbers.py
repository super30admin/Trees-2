# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:   
    """Implementation using recursion int return function
    Time complexity-O(n)
    Space complexity-O(h)"""
    def sumNumbers(self, root: TreeNode) -> int:
        sum1=0
        return self.helper(root, sum1)
    
    def helper(self, root, sum1)->int:
        if not root:
            return 0
        sum1=sum1*10+root.val
        case1=self.helper(root.left, sum1)
        if root!=None and root.left is None and root.right is None:
            return sum1
        case2=self.helper(root.right, sum1)
        return case1+case2
    
    """Implementation using recursion void return function"""
#     def __init__(self):
#         self.totalSum=0
        
#     def sumNumbers(self, root: TreeNode) -> int:
#         sum1=0
#         self.helper(root, sum1)
#         return self.totalSum
    
#     def helper(self, root, sum1):
#         if not root:
#             return
#         sum1=sum1*10+root.val
#         self.helper(root.left, sum1)
#         if root!=None and root.left is None and root.right is None:
#             self.totalSum+=sum1
#         self.helper(root.right, sum1)
        
        
        
    """Implementation using iterative approach using stack"""   
        # if root==None:
        #     return 0
        # totalsum,sum1=0,0
        # stack=[]
        # while root!=None or len(stack)!=0:
        #     while root!=None:
        #         sum1=sum1*10+root.val
        #         stack.append((root,sum1))
        #         root=root.left
        #     li=stack.pop()
        #     root=li[0]
        #     sum1=li[1]
        #     if root!=None and root.left is None and root.right is None:
        #         totalsum+=sum1
        #     root=root.right 
        # return totalsum
            
        
        
        