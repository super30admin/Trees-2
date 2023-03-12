#Time Complexity : O(N), N being the number of values in tree. 
#Space Complexity : O(h), h being the height of the tree, or O(logN).
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Got an issue where the result was double and 
#had to debug and check. 

#Your code here along with comments explaining your approach in three sentences only
'''Traverse through the tree and add if both left and right of node is null. Else 
multiply by 10 and add the value at node. 
'''
class Solution:
    #initialize the sum to zero. 
    def __init__(self):
        self.sum = 0
    def helper(self, number, node):
        #if both left and right node are None, then add to sum. 
        if node.left==None and node.right==None:
            self.sum = self.sum+number
        else:
            #call helper function with left node and right node. 
            if node.left:
                self.helper(number*10+node.left.val, node.left)
            if node.right:
                self.helper(number*10+node.right.val, node.right)
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root.val, root)
        return self.sum
