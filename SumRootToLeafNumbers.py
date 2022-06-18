#TC: O(n)
#SC: O(h) where h is the height of the tree
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
        self.result=0
        def inorder(root,v):
            if root==None: return
            inorder(root.left,v*10+root.val)
            if root.left==None and root.right==None: self.result=self.result+v*10+root.val
            inorder(root.right,v*10+root.val)
        
        inorder(root,0)
        return self.result

#we can do it using postorder and preorder also
'''
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.result=0
        def inorder(root,v):
            if root==None: return
            inorder(root.left,v*10+root.val)
            
            inorder(root.right,v*10+root.val)
            if root.left==None and root.right==None: self.result=self.result+v*10+root.val
        inorder(root,0)
        return self.result
'''
        

#using function with out result variable
'''

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        def inorder(root,v):
            if root==None: return 0
            
            if root.left==None and root.right==None: return v*10+root.val
            return inorder(root.left,v*10+root.val)+inorder(root.right,v*10+root.val)
        return inorder(root,0)
         
'''
#code using the physical stack and iterative meathod
'''
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        stack=[]
        res=0
        v=0
        while(root!=None or len(stack)!=0):
            while(root!=None):
                v=v*10+root.val
                stack.append((root,v))
                
                root=root.left
            (root,v)=stack.pop()
            if root.left==None and root.right==None: res+=v
            root=root.right
        return res
'''