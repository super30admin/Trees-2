""" 
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Time Complexity: O(n)
Space Complexity: O(n)
"""

#use hm to store inorder values and their indices

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def buildTree(inorder, postorder):
    
    hm = {}
    
    for i, val in enumerate(inorder):
        hm[val] = i
    
    def helper(inorder, postorder, inStart, inEnd, postStart, postEnd):
            
            if inStart > inEnd or postStart > postEnd:
                return None
            
            rootVal = postorder[postEnd]
            root = TreeNode(rootVal)
            index = hm[rootVal]
            
            
            root.left = helper(inorder, postorder, inStart, index-1, postStart, postStart + index - inStart - 1)
            root.right = helper(inorder, postorder, index+1, inEnd, postStart + index - inStart, postEnd-1)
            
            return root
    
    
        
    return helper(inorder, postorder, 0, len(inorder)-1, 0, len(postorder)-1)
    
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
root = buildTree(inorder, postorder)
print(root) 