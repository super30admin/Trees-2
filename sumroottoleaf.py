# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        def sumNumbersDFS(root, sumnum):
            if (not root): 
                return 0
            #compute prev*10+root.val at each step
            sumnum = sumnum * 10 + root.val
            left=sumNumbersDFS(root.left, sumnum) 
            #check if leaf node, add to result
            if (not root.left and not root.right): return sumnum
            right=sumNumbersDFS(root.right, sumnum)
            return left+right
    
    
        """
        :type root: TreeNode
        :rtype: int
        """
        return sumNumbersDFS(root,0)
#O(N)
#O(1)