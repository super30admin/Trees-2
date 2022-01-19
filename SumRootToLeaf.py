# Recursive Preorder
# // Time Complexity : O(2^N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    summation = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.summation 
        
    def helper(self,root, num):
        # base case
        if (root == None):
            return 
          
        # logic
        if root.left == None and root.right == None:
            self.summation += num*10 + root.val
        self.helper(root.left, num*10 + root.val)
        self.helper(root.right, num*10 + root.val)
        
# Recursive output for inorder
# // Time Complexity : O(2^N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    summation = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.summation 
        
    def helper(self,root, num):
        # base case
        if (root == None):
            return 
          
        # logic 
        self.helper(root.left, num*10 + root.val)
        if root.left == None and root.right == None:
            self.summation += num*10 + root.val
        self.helper(root.right, num*10 + root.val)



# Iterative Solution

# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        summation = 0
        currSum = 0
        st = list()
        while(root != None or st != []):
            while root != None:
                currSum = currSum*10 + root.val  
                p = (root, currSum)
                st.append(p)
                root = root.left
            
            p = st.pop()
            root = p[0]
            currSum = p[1]
            if root.left == None and root.right == None:
                summation += currSum
            root = root.right
        
        return summation
            
        
        