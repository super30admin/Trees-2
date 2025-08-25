# Time Complexity : It is O(n) since we are iterating with all nodes.
# Space Complexity : It is O(h) considering the height of the tree in the stack.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class Solution:
    result =0 
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        Solution.result=0
        self.rootToLeaf(root,0)
        return Solution.result

    def rootToLeaf(self, root: Optional[TreeNode], sumOfLeaves : int) ->int:

        if(root ==None):
            return
        sumOfLeaves = sumOfLeaves * 10 +root.val
        
        if(root.left==None and root.right==None):
            Solution.result += sumOfLeaves

        self.rootToLeaf(root.left, sumOfLeaves)
     
        self.rootToLeaf(root.right,sumOfLeaves)

