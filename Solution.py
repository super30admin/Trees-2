'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- store the inorder traversal array in a dictionary with their indexes to obtain the left and right subtree
- start with back of postorder traversal since the last element would be the root of the tree, recurse with start and end indices for left and right subtree
- call recursion on right child first becuase traversing the postorder array from back will cover the right child first

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.idx=len(postorder)-1
        # root=postorder[-1]
        # print(root)
        self.dicti={}
        for i in range(len(inorder)):
            self.dicti[inorder[i]]=i
            
        
        return self.helper(inorder, postorder, 0, len(inorder)-1)
    
    def helper(self, inorder: List[int], postorder: List[int], start, end):
        if start>end or self.idx<0:
            return None
        
        rootIndex= self.dicti[postorder[self.idx]]
        node= TreeNode(postorder[self.idx])
        self.idx-=1
        
        node.right= self.helper(inorder, postorder, rootIndex+1, end)
        node.left = self.helper(inorder, postorder, start, rootIndex-1)
        
        return node
        
        
'''
PROBLEM 2

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- recurse the tree maintaining the sum of all nodes covered
- once we reach a leaf node, add the sum to result sum
- return the result sum

'''



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    currSum=0
    def sumNumbers(self, root: TreeNode) -> int:
        
        
        self.helper(root, 0)
        return self.currSum
    
    def helper(self, root: TreeNode, sums):
        if root==None:
            return
        
        sums=sums*10 + root.val
        if root.left==None and root.right==None:
            self.currSum+=sums

        
        self.helper(root.left, sums)
            
        self.helper(root.right, sums)
            
            
        
        