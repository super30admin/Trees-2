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
        def helper(node, s):
            if not node:
                return ""
            elif node.left == None and node.right == None:
                return str(s) + str(node.val)
            return helper(node.left, str(s) + str(node.val)) + '&' + helper(node.right, str(s) + str(node.val))
        
        st = helper(root, "")
        print(st)
        l = st.split('&')
        sum1 = 0
        for s in l:
            if s == "":
                pass
            else:
                sum1 = sum1 + int(s)
        return sum1    