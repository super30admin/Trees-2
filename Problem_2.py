"""
Time Complexity : inside function
Space Complexity : inside function
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        """
        Inorder traversal - iterative
        Time Complexity : O(N)
        Space Complexity : O(H)
        """
        if root == None: return 0
        root_st = []
        num_st = []
        res = 0
        currNum = 0
        
        while root or root_st:
            while root:
                currNum = currNum * 10 + root.val
                root_st.append(root)
                num_st.append(currNum)
                root = root.left
                
            currNum = num_st.pop()
            root = root_st.pop()
            
            if root.right == None and root.left == None:
                res += currNum
                
            root = root.right
            
        return res
                
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        """
        Inorder traversal - recursive
        Time Complexity : O(N)
        Space Complexity : O(N)
        """
        self.res = 0
        
        def helper(root, currNum):
            # Base Condition
            if root == None : return
            
            #logic
            if (root.left == None and root.right == None):
                self.res += currNum * 10 + root.val

            helper(root.left, currNum * 10 + root.val)
            helper(root.right, currNum * 10 + root.val)
            
        helper(root, 0)
        return self.res

                
# Approach - 3
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        """
        Preorder traversal - recursive
        """
        self.res = 0
        
        def helper(root, currNum):
            # Base Condition
            if root == None : return
            
            #logic
            helper(root.left, currNum * 10 + root.val)
            
            if (root.left == None and root.right == None):
                self.res += currNum * 10 + root.val
                
            helper(root.right, currNum * 10 + root.val)
            
        helper(root, 0)
        return self.res

# Approach - 4
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        """
        Postorder traversal - recursive
        """
        self.res = 0
        
        def helper(root, currNum):
            # Base Condition
            if root == None : return
            
            #logic
            helper(root.left, currNum * 10 + root.val)
            
            if (root.left == None and root.right == None):
                self.res += currNum * 10 + root.val
                
            helper(root.right, currNum * 10 + root.val)
            
        helper(root, 0)
        return self.res
       
                
        