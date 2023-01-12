# Time Complexity :
# O(N)  - Size of the Tree

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#Do a traversal of the tree and keep a curr number which is added to the sum whenever we hit a leaf node.
#This current number is the integer value of concatenating all the values seen until then


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.curr_sum = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.traverse(root,0)
        return self.curr_sum

    def traverse(self,root,currNum):
        if root == None:
            return

        currNum = currNum * 10 + root.val

        if root.left == None and root.right == None :
            self.curr_sum += currNum
        
        self.traverse(root.left,currNum)
        self.traverse(root.right,currNum)
