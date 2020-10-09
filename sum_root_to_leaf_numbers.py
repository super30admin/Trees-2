# O(N) TIME AND O(d) space where n is no.of nodes and d is space
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.total_sum = 0
    def sumNumbers(self, root: TreeNode) -> int:
        self.findPaths(root,0)
        return self.total_sum
        
    def findPaths(self,node,running_number):
        if node is None:
            return
        running_number = running_number * 10 + node.val
        if node.left is None and node.right is None:
            self.total_sum += running_number
        self.findPaths(node.left,running_number)
        self.findPaths(node.right,running_number)

    
        

