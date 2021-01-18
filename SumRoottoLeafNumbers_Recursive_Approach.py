
#Recursive approach

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
    result=0
    def sumNumbers(self, root: TreeNode) -> int:
        if root==None:
            return 0
        cursum=0
        self.helper(root,0)
        return self.result
    
    def helper(self,root: TreeNode,cursum: int):
        if (root==None): 
            return
        cursum=cursum*10+root.val
        if(root.left==None and root.right==None):
            self.result+=cursum
        self.helper(root.left,cursum)
        self.helper(root.right,cursum)
                
        