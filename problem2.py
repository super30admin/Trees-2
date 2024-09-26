# Time Complexity : O(N) not sure
# Space Complexity : O(N) not sure
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findNumbers(self, node, result, number):
        
        #Append each root to leaf path number to the result list when we reach the leaf node
        if node.left!=None and node.left.left==None and node.left.right ==None:
            result.append(number+str(node.left.val))

        #Append each root to leaf path number to the result list when we reach the leaf node
        if node.right!=None and node.right.left==None and node.right.right ==None:
            result.append(number+str(node.right.val))

        # Recursively append digits for the left subtree
        if node.left!=None:
            self.findNumbers(node.left, result, number+str(node.left.val))

        # Recursively append digits for the right subtree
        if node.right!=None:
            self.findNumbers(node.right, result, number+str(node.right.val))
        
        
    def sumNumbers(self, root: TreeNode) -> int:
        if root == None:
            return 0
        if root.left == None and root.right == None:
            return root.val
        # Global list to store each root to leaf path number
        result = []
        sum = 0
        number = str(root.val)
        self.findNumbers(root, result, number)
        # Add all the numbers in result list to get the final sum
        for x in range(len(result)):
            sum += int(result[x])
        return sum
        
        
        