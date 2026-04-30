# // Time Complexity : O(n)
# // Space Complexity : O(h) where h is the height of the tree, for recursive stack space
# // Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        self.res=0

        def helper(root,cur):  
            if root == None: return          
            cur=cur*10 + root.val
            if root.left==None and root.right==None:
                self.res+=cur
                return
            helper(root.left,cur)
            helper(root.right,cur)

        helper(root,0)

        return self.res
