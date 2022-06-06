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
        stack = []
        numsSt = []
        
        currNum = 0
        addition = 0
        
        while root != None or len(stack) != 0:
            while root != None:
                currNum = currNum * 10 + root.val
                stack.append(root)
                numsSt.append(currNum)
                root = root.left
            
            root = stack.pop()
            currNum = numsSt.pop()
            
            #inorder
            if root.left == None and root.right == None:
                addition +=  currNum
            
            root = root.right
        
        return addition
            
            
            
        
        
            
