# Time Complexity : O(n) n is the number of elements in the tree
# Space Complexity : O(h)  here h is the height of the tree that means the recursive stack will have values upto the height of tree max
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach : - Here we recursively traverse the tree and add values of every branch in sum 
# and once we hit when root is null we exit the recursion



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    sum = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.dfs(root, 0)
        return self.sum
    
    def dfs(self,root, num):
        if root == None:
            return
        
        if root.left == None and root.right == None:
            self.sum = self.sum + num*10+ root.val
            return

        self.dfs(root.left, num*10+root.val)
        self.dfs(root.right, num*10+root.val)