# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#LC: 129, yes
#problems: NA
#TC: O(N) , n is. size of stack 
#SC: O(H), h is height of tree

#RECURSIVE 
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        def helper(root, currNum):
            #base
            if root is None:
                return
            
            print(root.val) # 4 9 5  1   0
            print(currNum)  # 0 4 49 49  4
            
            #logic
            currNum = currNum*10 + root.val
            
            
            if root.left is None and root.right is None:
                self.result += currNum
                
            helper(root.left, currNum)
            helper(root.right, currNum)
        helper(root, 0)
        return self.result

#TC: O(N) , n is. size of stack 
#SC: O(H), h is height of tree
#ITERATIVE 
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        stack = []
        numSt = []
        
        currNum = 0
        result = 0
        
        while root is not None or len(stack) > 0:
            while root is not None:
                stack.append(root)
                currNum = currNum*10 + root.val
                numSt.append(currNum)
                root = root.left
            root = stack.pop()
            currNum = numSt.pop()
            if root.left is None and root.right is None:
                result += currNum
                
            root = root.right
            
        return result
                