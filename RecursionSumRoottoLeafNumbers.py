#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(h) i.e. h is the height of the tree
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/p5lAtjwqOZs
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,0)
        return self.result
    def helper(self, root: TreeNode, currentNumber :int):
        #base case for the recursion function
        if root==None:
            return
        
        #logic for the recursion function
        #calling the left recursion and their will be two number stored in the stack root and the root current number with sum of the root till that number
        self.helper(root.left,  currentNumber*10+root.val)
        #print("UP")
        #print(root.val)
        #print("Currmum",currentNumber*10+root.val)
        #printing the result in an inorder form we can keep the if condition above the left and after the right recursion for pre and post order 
        #if condition will check the leaf node and if the left node is found then there would be sum at every leaft node
        if(root.left==None and root.right == None):
            self.result += currentNumber*10+root.val
            #print("result",self.result)
        #calling the right resursion tree
        self.helper(root.right,  currentNumber*10+root.val)
        #print("Down")
        #print(root.val)
        #print(currentNumber*10+root.val)
