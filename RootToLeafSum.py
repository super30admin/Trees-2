# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
// Time Complexity: o(n)
//Space Complexity: o(n)
// Did it run on leetcode: Yes
class Solution(object):
    def sumNumbers(self, root):
        return  self.helper(root,0)
    def helper(self,root,sum1):
            if not root:
                return 0
            if (root.left == None  and root.right == None) :
                 return sum1 * 10 + root.val
            return self.helper(root.left,sum1*10 + root.val) +  self.helper(root.right,sum1*10 + root.val)
        
        
