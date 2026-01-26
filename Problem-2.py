#129. Sum Root to Leaf Numbers
# Time Complexity :O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
#resursively call the nodes in tree either is preorder,inorder,postorder. Maintin the sum at each node by passing sum as paramerter in recursion
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.res=0 # results as global variable
        self.helper(root,0)#call helper passing initial sum as 0
        return self.res
    
    def helper(self, root, sum):
        #condition
        if root is None:
            return
        sum=sum*10+root.val
        if root.left is None and root.right is None: # if leaf node then add the sum to result
            self.res+=sum
        self.helper(root.left, sum)
        self.helper(root.right, sum)
