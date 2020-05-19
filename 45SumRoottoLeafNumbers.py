"""
// Time Complexity :T = O(n) for traversing through entire BT.
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA

//Explanation:
Add nodevalue, and currentsum in stack.
traverse till the end of the tree->Add the currentsum in finalsum
pop the node from the stack along with it's currentsum.
start traversing from this new node. 
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    currentSum = 0
    def sumNumbers(self, root: TreeNode) -> int:
        stack = []
        FinalSum = 0
        while root is not None or len(stack) != 0:
            while root is not None:
                self.currentSum = self.currentSum * 10 + root.val
                stack.append([root,self.currentSum])
                root = root.left
            root,self.currentSum = stack.pop(-1)
            #print("*",type(root),self.currentSum)
            if root.left is None and root.right is None:
                FinalSum += self.currentSum
            root = root.right
        return FinalSum
