#All TC on leetcode passed


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Here we append each node value to curNum by multiplying curNum by 10 and adding cur node val. 
    #Once the cur node has no children then we add the curNum to result.
    #Time complexity - O(n) - where n is total no. of nodes
    #Space complexity - O(h) where h is ht of tree
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        #integer recurrsive approach
        def helper(root, curNum):
            if not root.left and not root.right:
                return curNum
            
            left = 0
            if root.left:
                left = helper(root.left, curNum*10+root.left.val)
            
            right = 0
            if root.right:
                right = helper(root.right, curNum*10+root.right.val)

            return left+right
        
        return helper(root, root.val)

#------------------------------OR-----------------------------------------------

        #void recurrsive approach
        self.res = 0
        def helper(root, curNum):
            if not root.left and not root.right:
                self.res += curNum

            if root.left:
                helper(root.left, curNum*10+root.left.val)
            
            if root.right:
                helper(root.right, curNum*10+root.right.val)
        
        helper(root, root.val)
        return self.res


#----------------------------------OR----------------------------------------
        #iterative approach
        stack = []
        stack.append([root, root.val])
        res = 0

        while stack:
            root, curNum = stack.pop()

            if not root.left and not root.right:
                res += curNum

            if root.left:
                stack.append([root.left, curNum*10+root.left.val])
            
            if root.right:
                stack.append([root.right, curNum*10+root.right.val])
        return res
        