"""
Time Complexity  : O(n) where n is the total number of nodes in a tree
Space Complexity : O(h) where h is the height of the tree
Did this code successfully run on Leetcode : Yes

Three line explanation of solution in plain english:
Traverse through the every node of tree. While traversing push currSum value to the stack along with the node.
once reached to the leaf node currSum will be the sum of all the root values from the root to that particular leaf.
currSum = currSum*10 + root.val

This problem can be solved using two methods:
1. Iterative appraoch
2. Recursion approach.

In the iterative approach we have to do the one to one mapping for every pooped value on the otherhand this happens automatically in case of recursive approach. Hence, when the number of elments that needs to push to the stack increases it is convinient to use the recursion instead of iterative approach.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        #Iterative approach
        stack = []
        numSt = []
        result = 0
        currSum = 0
        while(root != None or len(stack) > 0):
            while(root != None):
                currSum = currSum * 10 + root.val
                stack.append(root)
                numSt.append(currSum)
                root = root.left
            root = stack.pop()
            currSum = numSt.pop()
            
            #Check leaf
            if root.left == None and root.right == None:
                result += currSum
            
            root = root.right
        
        return result