#129. Sum Root to Leaf Numbers
'''
Leetcode all test cases passed: Yes
Solution:
     def sumNumbers(self, root: Optional[TreeNode])
        n is the no of nodes in the tree
        h is the height of tree 
        Space Complexity: O(h)
        Time Complexity: O(n)
'''
class Solution:
    def __init__(self):
        self.result = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.dfs(root,0)
        return self.result
    def dfs(self,root,currNum):
        #Base
        if root == None:
            return
        #logic
        currNum = currNum * 10 + root.val 
        if root.left == None and root.right == None:
            self.result += currNum
        #action
        self.dfs(root.left,currNum)
        self.dfs(root.right,currNum)
