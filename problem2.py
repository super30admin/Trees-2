#Time Complexity : O(n)
#Space Complexity :O(h), where h is the height of the tree
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def dfs (curNode, num):
            if not curNode:
                return 0
            
            num = num*10+ curNode.val
            if not curNode.left and not curNode.right:
                return num
            return dfs(curNode.left,num) +dfs(curNode.right,num)
        
        return dfs(root,0)
