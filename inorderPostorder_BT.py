# // Time Complexity : O(n^2)
# // Space Complexity : O(n^2), recursive stack * for every n we create n number of spaces for creating four arrays
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach:

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        if len(inorder) == 0 or len(postorder) == 0:
            return None
        
        #creating new treenode, root->last element of postorder
        root = TreeNode(postorder[len(postorder)-1])

        #figure out position of root value in the inorder list
        index = -1
        for x in range(0, len(inorder)): #O(n)
            if inorder[x] == root.val:
                index = x
                break
        
        #figure out the sizes of left and right side
        leftSize = index
        rightSize = len(inorder)-1-index
        
        #create four arrays: inorder(left & right) and postorder(left & right)
        inLeft = inorder[0:index]
        inRight = inorder[index+1: len(inorder)]
        
        postLeft = postorder[0: leftSize]
        postRight = postorder[leftSize: len(postorder)-1]
        
        #make recursive calls
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)
        
        return root
        
        
                
        
        
        