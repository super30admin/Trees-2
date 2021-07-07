# Runs on Leetcode
# Runtime- O(n)
# Memory- O(1)

'''
1) Recursively travel through tree till we reach left leaf node of the tree. and then right nodes.

2) Maintaining the sum till last level in temp variable and adding it to result when we reach any leaf node of the tree

'''


class Solution:
    def sumNumbers(self, root):
        if not root:
            return 0
        
        self.result = 0
        self.helper(root,str(root.val),0)
        return self.result
        
    def helper(self,root,temp,result):
        if root.left is None and root.right is None:
            self.result += int(temp)
        if root.left is not None: 
            self.helper(root.left,temp+str(root.left.val),self.result)
        if root.right is not None:
            self.helper(root.right,temp+str(root.right.val),self.result)
