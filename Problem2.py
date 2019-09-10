# Time Complexity : O(n) (We have to pass throught every element of tree.)
# Space Complexity : O(1) (We are not storing any additional information. Also helper function is calling recusrion. )
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Initialize global variable to store sum of all branches.
# - Make helper function which takes tree node and current number.
# - Every time helper function is called on left and right child, multiply recived value by 10 and add current node value, than pass this to the children.
# - If we reached at the, end add recieved number to the total.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
#   Initialize gloabl variable total.
    def __init__(self):
        self.total = 0
    
    def sumNumbers(self, root: TreeNode) -> int:
#       Check edge case
        if not root:
            return self.total
#       Call helper function with root node and value
        self.helper(root, root.val)
#       After execution of helper function is finished return total value.
        return self.total
        
    def helper(self, root, mul):
#       Check if we reach at the end of tree. If it is true than add recived value to total.
        if root.left == None and root.right == None:
            self.total += mul
            
#       If current node have left child, add current node value to (recived value * 10) and pass this to helper function.
        if root.left:
            self.helper(root.left, mul * 10 + root.left.val)
            
#       Same as above but for right child.
        if root.right:
            self.helper(root.right, mul * 10 + root.right.val)
            
        
