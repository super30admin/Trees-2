#Time Complexity: O(N)
#Space Complexity: O(H) or O(logN) Height of the binary tree, Recursive call stack

class Solution(object):

    def __init__(self):
        self.result = 0

    def sumNumbers(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        currentSum = 0
        

        def helper(root,currentSum):

            if root is None:
                return
            
            currentSum = (currentSum * 10) + root.val

            if root.left is None and root.right is None:
                self.result += currentSum
                return

            helper(root.left,currentSum)
            helper(root.right,currentSum)

        
        helper(root,currentSum)
        return self.result








        