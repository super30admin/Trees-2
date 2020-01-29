# Time Complexity : O(n^2)
# Space Complexity O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Since postorder is left right root therefore the last element of the postorder list will be root
using the roort from postorder finding the root and its index in the inorder traversal
Based on the root finding the rightinorder, left inorder, right post order and left psot order
Recursively traversing on right side and the left side

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if(len(inorder) == 0 or len(postorder)==0):
            return None
        
        indx = -1
        a = len(postorder)
        root = TreeNode(postorder[a-1]) # last elemet of postorder is the root
        
        for i in range(len(inorder)):
            if(inorder[i] == postorder[a-1]): # finding the root in the inorder list
                indx=i
                break
        leftin = []
        rightin = []
        leftpost=[]
        rightpost = []
        
        # finding the righthand and left hand side of the tree
        leftin = inorder[:indx]
        rightin = inorder[indx+1:]
        leftpost = postorder[:indx]
        rightpost = postorder[indx: a-1]

        # recusrively traversing on the right and the left hand side
        
        root.right = self.buildTree(rightin, rightpost)
        root.left= self.buildTree(leftin,leftpost)
        return root

##########################################################################################
#Problem 2:

# Time Complexity : O(n)
# Space Complexity O(1), Recursive Stack: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
traversing on the left and right hand side of the tree
calculating the sum at every node using the formula val1*10 + root.val
if both the left and right nodes are present that traversing the left node and calculating the sum
simimlarl traverse the right node and claulate the sum and add both the sum together.
Once Done recurse back
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
      
        
        return self.helper(root, 0)

        
    
    
    def helper(self, root:TreeNode, val1):
        
    #Base case
        if(not root):
            return 0
        if not root.left and not root.right: # if no children nodes are there
            return val1*10 + root.val;
        
        
        #logic
        # if children nodes are present. Calculate the sume at each childeren node and sum them
        return (self.helper(root.left, val1*10+root.val) + self.helper(root.right, val1*10+root.val))
