# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Solution  1
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        #Approach: Brute-force recursive
        #Time Complexity: O(n^2) // finding idx in every recursion call
        #Space Complexity: O(n^2) // in/post-Arrays in every recursion call
        #where, n is the length of the list
        
        #edge
        if len(postorder) == 0:
            return None
        
        self.idx = len(postorder) - 1
        self.inorder_map = {} #val -> index
        for i in range(len(inorder)):
            self.inorder_map[inorder[i]] = i
            
        return self.helper(postorder, 0, len(inorder) - 1)
    
    def helper(self, postorder, start, end):
        #base
        if start > end:
            return None
        
        #logic
        rootVal = postorder[self.idx]
        root = TreeNode(rootVal)
        self.idx -= 1
        
        rIdx = self.inorder_map[rootVal]            #rootIndex in inorder
        root.right = self.helper(postorder, rIdx + 1, end)
        root.left = self.helper(postorder, start, rIdx - 1)
        
        return root
    
    #Solution 2
    """
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        #Approach: Brute-force recursive
        #Time Complexity: O(n^2) // finding idx in every recursion call
        #Space Complexity: O(n^2) // in/post-Arrays in every recursion call
        #where, n is the length of the list
        
        #edge / base
        if len(postorder) == 0:
            return None
        
        #logic
        rootVal = postorder[-1]
        root = TreeNode(rootVal)
        
        idx = inorder.index(rootVal)
        
        inLeft = inorder[:idx]
        inRight = inorder[idx + 1:]
        postLeft = postorder[:idx]
        postRight = postorder[idx:-1]
        
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)
        
        return root
    """