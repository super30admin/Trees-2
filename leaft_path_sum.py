'''

Did it run on leetcode: Yes
Problems faced: How to create number from root to leaft path

Time Complexity: 0(N)
Space Complexity: 0(N)

Algorithm:
- Going down the nodes you multiply your node value into 10 to shift the bits.
- When you reach the leaf node just return the sum

'''



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        return self.sumNumbersUtil(root,0)
        
    def sumNumbersUtil(self,node,leafSum):
        
        if not node:
            return 0
        
    
        if not node.left and not node.right:
            return leafSum*10+node.val
        
        else:
            leftSum = self.sumNumbersUtil(node.left,leafSum*10+node.val)
            rightSum = self.sumNumbersUtil(node.right,leafSum*10+node.val)
            return leftSum + rightSum
            
        