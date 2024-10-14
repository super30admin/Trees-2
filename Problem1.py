# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result  = 0
    def sumNumbers(self, root): #T.C -> O(N),S.C-> O(N)
        """
        :type root: TreeNode
        :rtype: int
        """
        self.helper(root,0)
        return self.result
    def helper(self,root,currSum):

        if(root == None): return

        currSum = (currSum*10) + root.val

        if(root.left == None and root.right == None):
            self.result += currSum
            return
        self.helper(root.left,currSum)
        self.helper(root.right,currSum)  