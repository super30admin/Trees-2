# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if(root == None):
            return 0
        sum = 0
        s = []
        nums =[]
        num = 0
        while(root != None or len(s) != 0):
            while(root != None):
                s.append(root)
                num = num * 10 + root.val
                nums.append(num)
                root = root.left
            
            root = s.pop()
            
            num = nums.pop()
            if(root.left is None and root.right is None):
                sum = sum + num
            
            root = root.right
        
        return sum
    
    