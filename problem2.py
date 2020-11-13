#time complexity O(n)
#space complexity (O(h)) height of the tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    _sum=0
    def sumNumbers(self, root: TreeNode) -> int:
        if root==None: return 0
        self.helper(root,0)#root current sum, total sum
        return self._sum
    
    
    def helper(self,root,currsum):
        
        #bas
        if root==None: return 
        if root.left==None and root.right==None:  
            self._sum+=currsum*10+root.val
            print(self._sum)
            return 

        
        #logic
        self.helper(root.left,currsum*10+root.val)
        self.helper(root.right,currsum*10+root.val)
        return self._sum
        
        
        