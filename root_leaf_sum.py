#Time Complexity: O(N).
#Auxiliary Space: O(N)
#Did this code successfully run on Leetcode :Yes





# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def __init__(self):
        self.result = 0
        
    def inorder(self,root,cur_sum):
        if not root:
            return
        cur_sum = cur_sum*10 +root.val
        self.inorder(root.left,cur_sum)
        if not root.left and not root.right:
            self.result+=cur_sum
        self.inorder(root.right,cur_sum)
        
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.inorder(root,0)
        return self.result