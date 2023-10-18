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
        # Time Complexity: O(N) N = number of nodes
        # Space complexity: O(N)
        self.result = 0

        def helper(root, num):
            if not root:  
                return
            num = num*10 + root.val
            helper(root.left,num)             
            helper(root.right,num)
            if (not root.left) and (not root.right):
                self.result += num

        helper(root,0)   
        return self.result

