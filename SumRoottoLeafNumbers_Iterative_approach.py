
#Iterative approach

#Time: O(n)
#space: O(h)
#did it run on leetcode successfully: yes 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root==None:
            return 0
        stack=[]
        result=0
        cursum=0
        while(root!=None or stack!=[]):
            while(root!=None):
                cursum=cursum*10 + root.val
                stack.append([root,cursum])
                root=root.left
            root,cursum=stack.pop()
            if(root.left==None and root.right==None):
                result+=cursum
            root=root.right
            
        return result
            
                
        