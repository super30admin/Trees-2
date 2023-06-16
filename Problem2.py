#Time complexity is: O(n)
#Space complexity is: O(n)
#Code ran successfully on leet code
#No issues faced while coding the program

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        #initialising the required variables and we will be calling the helper function
        self.final_sum=0
        self.helper(root,0)
        return self.final_sum
    
    def helper(self,root,CurrNum):
        #base
        #If the root is None, we will return nothing
        if(root==None):
            return
        #We will mulpitlying the current value with 10 and we will be adding the root value
        CurrNum=CurrNum*10+root.val
        #checking the leaf node condition and adding the CurrNum to the final sum
        if(root.left==None and root.right==None):
            self.final_sum+=CurrNum
        #Moving towards the left side of the tree
        self.helper(root.left,CurrNum)
        #Moving towards the right side of the tree
        self.helper(root.right,CurrNum)
