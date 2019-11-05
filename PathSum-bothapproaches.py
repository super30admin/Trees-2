# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""Recursive solution"""

#Accepted by leetcode
#Time complexity - O(n) since we are traversing through every node
#Space complexity - O(n)because of recursive stack in memory
#Approach - We store the sum value to be value*10+root.val and pass this on to left and right nodes while travesing the tree

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def helper(root,result):
            if root==None: return 0
            if (root.left==None and root.right==None): return root.val+result*10
            return  helper(root.left,result*10+root.val) + helper(root.right,result*10+root.val)
        return helper(root,0)
		

"""Iterative solution"""

#Accepted by leetcode
#Time complexity - O(n) since we are traversing through every node
#Space complexity - O(n)because of recursive stack in memory
#Approach - Implementation using stack, push the node values along with previous sum as a tuple into the stack and pop out when None is reached

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        result=0
        stack=[]
        stack.append((root,0))
        while (stack!=[]):
            pair=stack.pop()
            root=pair[0]
            value=pair[1]
            if root!=None:
                if root.left ==None and root.right==None:
                    result=result+ root.val+value*10
                stack.append((root.left,root.val+value*10))
                stack.append((root.right,root.val+value*10))
        return result