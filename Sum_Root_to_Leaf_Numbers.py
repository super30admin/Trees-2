# Time Complexity : O(N) since has to visit each node
# Space Complexity : O(H) to keep the recursive stack, where H is a tree height
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


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
        #send helper function with root and currSum
        return self.helper(root, 0)
    
    def helper(self, root, currSum):
        #Base Case
        if root == None:
            return 0
        
        # multiple with currsum and add with the root.val to get the root-leaf path that represents number at particular root.val
        currSum = currSum * 10 + root.val
        
        # if it's hit leaf node return currSum which was calculated in previous step 
        if not root.left and not root.right:
            return currSum
          
        # make a recursive call to root.left and root.right with currSum  
        return self.helper(root.left, currSum) + self.helper(root.right, currSum)
