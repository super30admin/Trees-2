# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity:O(N)
#Space Complexity:O(h),h is the height of the binary tree
#Did it run successfully on Leetcode:Yes
#Here I am pushing my root(the one on whihc I'm operating) , and root value into the stack. If the stack is not empty and is not null I proceed to its left and right nodes. 
#I am keeping track of current value with respect to its node. Once I encounter that left and right nodes are null I add up th evalue to the result.

#Iterative solution:
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        stack,res=[(root,root.val)],0
        while stack:
            node,value=stack.pop()
            if node:
                if not node.right and not node.left:
                    res+=value
                if node.right:
                    stack.append((node.right,value*10+node.right.val))
                if node.left:
                    stack.append((node.left,value*10+node.left.val))
        return res
    
#Recursive solution

    def sumNumbers(self, root):
        self.res = 0
        self.dfs(root, 0)
        return self.res
    def dfs(self,root,value):
        if root:
            self.dfs(root.left,value*10+root.val)
            self.dfs(root.right,value*10+root.val)
            if not root.left and not root.right:
                self.res+=value*10+root.val

#
