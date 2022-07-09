# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity : O(N)
#Space Complexity : Height of the tree-> O(N)
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.output = 0
        self.helper(root,0)
        return self.output
    
    def helper(self,root,currSum):
        if(root == None):
            return
        
        #Condidtion
        currSum = (currSum)*10 + root.val
        print(currSum)
        if(root.left == None and root.right == None):
            self.output += currSum
            return
        self.helper(root.left,currSum)
        self.helper(root.right, currSum)
        
