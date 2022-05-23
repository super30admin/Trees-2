#Time Complexity: O(N)
#Space Complexity : O(H) H-> height of tree
#Did your code run on leetcode : yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None: return 0
        return self.helper(root,0)
    
    def helper(self, root: Optional[TreeNode],currentNum:int)->int:
        if root == None: return 0
        
        #preorder -> check whether both nodes are leaf nodes
        if root.left == None and root.right == None:
            return currentNum * 10 + root.val
    
    #sum of left part of the tree + sum of right part of the tree
        return self.helper(root.left,currentNum * 10 + root.val) + self.helper(root.right,currentNum * 10 + root.val)
        #stack.pop()
      
        
        
            
