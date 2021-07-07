#leet code -129
# Time complexity -O(N)
#space complexity-O(N)



# Recursive Solution

# Definition for a binary tree node.
class TreeNode(object):
     def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.helper(root,0)
    
    def helper(self,root,result):
 
        if root==None: return 0
        if (root.left==None and root.right==None): return root.val+result*10
        return  self.helper(root.left,result*10+root.val)+self.helper(root.right,result*10+root.val)
        
        
        
# Iterative Solution

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

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