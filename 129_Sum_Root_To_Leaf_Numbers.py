# Leetcode problem link : https://leetcode.com/problems/sum-root-to-leaf-numbers/
# Time Complexity : O(n)
#  Space Complexity : O(maxdepth)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
       Intuition: O(n) => The intuition behind this approach is maintaining a current sum till the node for each node and add to total sum for leaf nodes
        
        
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    # global variable to store total sum
    total = 0
    def sumNumbers(self, root: TreeNode) -> int:
        # call recurisve function with root node and current sum as zero
        self.recursion(root,0)
        return self.total
    
    def recursion(self,root,currSum):
        # if node doesnt exist then we can instead add 0 to the sum
        if not root:
            return 0
        # at each point calculate current sum till the current node and store in a temp
        temp = currSum*10 + root.val
        # if its a leaf node then we can add the sum to total sum
        if not root.left and not root.right:
            self.total += temp
            return
        # invoke recursively for both left and right nodes
        self.recursion(root.left,temp)
        self.recursion(root.right,temp)