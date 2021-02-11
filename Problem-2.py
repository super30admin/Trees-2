#Time Complexity :O(n)
#Space Complexity :O(h) recursive stack
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    ans=0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if(root==None):
            return 0
        
        self.helper(root,0)
        return self.ans
    
    def helper(self,root,value):
        #base
        if(root==None):
            return 
        #logic
        value=value*10+root.val
        self.helper(root.left,value)
        if(root.left==None and root.right==None):
            self.ans+=value
        self.helper(root.right,value)