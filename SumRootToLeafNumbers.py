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
        if not root:
            return 0
        
        self.ans = 0

        def helper(root, total):
            #if we hit a null node, nothing to process.
            if not root:
                return

            if not root.left and not root.right:
                total = (total * 10) + root.val
                #We are at the leaf node. Time to add total to the result.
                self.ans += total
                return
            
            curTotal = (total * 10) + root.val

            # Expand our search
            helper(root.left, curTotal)
            helper(root.right, curTotal)

        helper(root, 0)
        return self.ans

    #TC: O(n)
    #SC : O(h)