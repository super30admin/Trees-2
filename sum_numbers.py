class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        
        
        def helper(node,pathsum):
            
            if node is None:
                return 0
            
            pathsum = pathsum*10 + node.val
            
            if node.left is None and node.right is None:
                return pathsum
            
            return helper(node.left,pathsum)+helper(node.right,pathsum)
        
        return helper(root,0)
        
        
        ''' here i am following dfs approack and keeping track of the pathsum, pathsum = pathsum*10 + node.val (current node we are on),
            time and space complexity is o(n), because we are traversing to each node once and using recursion stack'''
