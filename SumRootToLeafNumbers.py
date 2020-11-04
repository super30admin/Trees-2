#Time Complexity : O(n) where n is number of nodes in the tree
#Space Complexity : O(H) where H in the height of the tree

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Keeping a global result, and a local currSum, iterating through each node in the tree going from root till leaf, we keep appending to make the complete number in CurrSum, which upon reach a leaf node we add the final root to leaf number to the final result. 

#Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        self.result = 0

        def getSum(root, currSum):
            if not root:
                return
            if not root.left and not root.right:
                self.result += currSum*10 + root.val

            getSum(root.left, currSum*10+root.val)

            getSum(root.right, currSum*10+root.val)

        getSum(root, 0)
        return self.result


    #ITERATIVE
#         stack = []
#         currSum, result = 0, 0
#         while root or stack:
#             while root:
#                 currSum = currSum*10 + root.val
#                 stack.append((root, currSum))
#                 root = root.left

#             root, currSum = stack.pop()
#             if not root.left and not root.right:
#                 result += currSum
#             root = root.right

#         return result
