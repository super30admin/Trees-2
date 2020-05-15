# Time Conplexity: O(N) where N is the Number of Nodes
#Space Complexity: O(H) where H is hright of the Tree


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
        result = 0
        st = []
        k = []
        sum1 = 0
        while(root!=None or len(st)!=0):
            while(root!=None):
                sum1 = sum1*10 + root.val
                st.append([root,sum1])
                root =root.left
            k = st.pop()
            print(k)
            root = k[0]
            sum1 = k[1]
            if root.left == None and root.right ==None:
                result = result+sum1
            root = root.right
            
        return result
    
==============================
#Recursive
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
        if root== None:
            return 0
            
        def helper (root, node_val): 
            if root!=None:
                helper(root.left, node_val * 10 + root.val)
                helper(root.right, node_val * 10 + root.val)
                if root.left == None and root.right == None:
                    self.sum += node_val * 10 + root.val
        self.sum = 0
        helper(root, 0)
        return self.sum
            
            
