'''

129. Sum Root to Leaf Numbers

TIME COMPLEXITY: O(n)
SPACE COMPLEXITY: O(h)
LEETCODE: Yes
DIFFICULTIES: I tried to solve, I couldn't. After watching the class, I was able to solve it.

'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
    
        def approach1(root):
            global res
            res = 0
            def traverse(root, cs):
                global res
                if root.left == None and root.right == None: 
                    cs = cs * 10 + root.val
                    res += cs
                    return
                cs = cs * 10 + root.val
                if root.left != None:
                    traverse(root.left, cs)
                if root.right != None:
                    traverse(root.right, cs)

                return

            traverse(root, 0)

            return res
        
        def approach2(root, res):
            if root.left == None and root.right== None:
                return res * 10 + root.val
            lv = 0
            if root.left != None:
                lv = approach2(root.left, res * 10 + root.val) 
            rv = 0
            if root.right != None:
                rv = approach2(root.right, res * 10 + root.val)
            return lv + rv
        
        
        # return approach1(root)
        return approach2(root, 0)
    
