# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Iterative Solution
    # Time Complexity - O(N)
    #Space Complexity - O(N)
    def sumNumbers(self, root: TreeNode) -> int:
        
        if root == None:
            return 0
        
        total=0
        queue=deque() # Usinf BFS approach
        queue.append((root,0))
        
        while queue:
            qsize=len(queue)
            
            for i in range(qsize):
                node,value=queue.popleft()
                if node.left == None and node.right==None:
                    total=total+value*10+node.val
                if node.left:
                    queue.append((node.left,value*10+node.val))
                if node.right:
                    queue.append((node.right,value*10+node.val))
                    
        return total
    
    '''
    Recursive Solution
    #Time Complexity - O(N)
    #Space Complexity - O(N)
    
    def sumNumbers(self, root: TreeNode) -> int:
        
        if root == None:
            return 0
        self.total=0
        self.helper(root,0)
        return self.total
    
    def helper(self,root,value):
        
        if root.left== None and root.right==None:
            value=value*10+root.val
            self.total+=value
            return
            
        value=value*10+root.val
        
        if root.left:
            self.helper(root.left,value)
        if root.right:
            self.helper(root.right,value)
        
        '''