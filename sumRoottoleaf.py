class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        '''
        Time complexity O(logn)
        Space complexity O(logn)

        bfs travarsal/dfs travarsal 
        when node is leaf add value to ans
        if not modify the value of node 
        '''
        
        ans = 0
        if root == None: return ans
        s = [root]
        while s:
            x = s.pop(0)
            if x.left == None and x.right == None:
                ans += x.val
            if x.left:
                x.left.val = x.val * 10 + x.left.val
                s.append(x.left)
            if x.right:
                x.right.val = x.val * 10 + x.right.val
                s.append(x.right)
        return ans
