# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        max_sum = 0
        def helper(root, cursum):
            nonlocal max_sum
            if root:
                cursum = cursum*10 + root.val 
                if not root.left and not root.right: # use it when processing
                    max_sum += cursum
                    return
                helper(root.left, cursum) 
                helper(root.right, cursum)
        helper(root, 0)  
        return max_sum

        
        # s = []
        # queue = [(root, root.val)]
        # while queue:
        #     node, val = queue.pop(0)
        #     if not node.left and not node.right:
        #         s.append(val)
        #     else:
        #         if node.left:
        #             value = (val * 10) + node.left.val  
        #             queue.append((node.left, value))       
        #         if node.right:
        #             value = (val * 10) + node.right.val  
        #             queue.append((node.right, value))   
        # return sum(s)
        def recursive(root, val, s):
            if root:
                if not root.left and not root.right:
                    s.append(val)
                if root.left:
                    curr = (val*10) + root.left.val
                    recursive(root.left, curr ,s)        
                if root.right:    
                    curr = (val*10) + root.right.val
                    recursive(root.right, curr, s) 

        s = []
        recursive(root, root.val, s)
        return sum(s)
