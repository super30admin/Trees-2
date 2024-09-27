
#time Complexity: O(n)
#Space Complexity: O(1)
#leetcode submission: successful
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.result=0
        self.helper(root,0)
        return self.result
    def helper(self,root,value):
        if root:
            self.helper(root.left,value*10+root.val)
            self.helper(root.right,value*10+root.val)
            if not root.left and not root.right:
                self.result +=value*10+root.val