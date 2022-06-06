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
    global addition
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        global addition
        addition = 0
        if root == None: return
        self.helper(root,0)
        return addition
    
    def helper(self, root: Optional[TreeNode],currentNum:int)->None:
        if root == None: return
        
        global addition
        
        #preorder -> check whether both nodes are leaf nodes
       
       #if root.left == None and root.right == None:
        #    addition +=  currentNum * 10 + root.val
         #   return
            
        self.helper(root.left,currentNum * 10 + root.val)
        if root.left == None and root.right == None:
            addition +=  currentNum * 10 + root.val
            return
        
        self.helper(root.right,currentNum * 10 + root.val)
            
