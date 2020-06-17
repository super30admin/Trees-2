# Time Complexity :O(n^2)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def helper(self,string,root,arr):
        if not root:
            #append number as sting in arr
            arr.append(int(string))
            return
        #concat int till leaf
        elif not root.left and not root.right:
            self.helper(string+ str(root.val),root.left,arr)
        elif root.left and not root.right:
            self.helper(string+ str(root.val),root.left,arr)
        elif root.right and not root.left:
            self.helper(string+ str(root.val),root.right,arr)
        elif root.left and root.right:
            self.helper(string+ str(root.val),root.left,arr)
            self.helper(string+ str(root.val),root.right,arr)
        
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        arr = []
        self.helper('',root,arr)
        # sum array
        return sum(arr)
        