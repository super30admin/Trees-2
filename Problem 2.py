# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time: O(n)
# Space: O(n) Stack space
class Solution(object):
    def __init__(self):
        self.arr = 0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        stack = []
        node_stack = []
        ans  = 0
        num = 0
        while root != None or len(stack) != 0:
            while(root!= None):
                num = num*10+root.val
                stack.append(num)
                node_stack.append(root)
                root = root.left
            num = stack.pop()
            root = node_stack.pop()
            if root.left == None and root.right == None:
                ans += num
            root = root.right
                
            
        return ans
                
                
        
        
