"""Approach:
We find the root index in inorder traversal list. Then use that to divide inOrder left and right. 
Then use same rootIdx to get postOrder left and postOrder right such that :rootIdx and rootIdx:-1
(i.e. until penultimate element, as the last element would be root)

TC: O(n^2) - we are creating 4 array copies and we are doing it at n roots also a for loop to find root.
SC: O(n^2)  - at each node we are creating extra arrays - for n nodes n arrays.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
         # None check
        if len(postorder) == 0: return None
        
        # find root in inorder
        rootVal = postorder[-1]
        # create a TreeNode for rootVal
        root = TreeNode(rootVal)
        rootIdx = 7000   # Index of root in Inorder traversal
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
                break
        # anything on left of rootIdx is left subtree
        inLeft = inorder[:rootIdx]
        # anything on right of rootIdx is right subtree
        inRight = inorder[rootIdx+1:]
        # first node is root, at index 0, so start at index 1 till rootIdx to get leftSubTree
        postLeft = postorder[:rootIdx]
        # rootIdx+1 onward till the end is right subtree
        postRight = postorder[rootIdx:-1]
        
        # recursively call buildTree on left and right of pre and in order arrays and assign it to root.left and root.right
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)
        
        return root

"""Approach:
Recursive approach without extra arrays. Use start and end indices for postorder.
And use map to get indices for root from inorder array in O(1)
TC: O(n) - we are going over 1 index at a time over preorder array, number of nodes in the tree is n
SC: O(n) - as we are constructing the inorder hashmap
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    m = None  # inorder array converted to k:v where k is array item and value is index, provides O(1) lookup
    idx = 0   # index used to get root elements from postorder list
    inorder = None
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # None check
        if len(postorder) == 0: return None
        # initialize index to last location in postorder array
        self.idx = len(postorder) - 1
        # create inorder arr to indices mapping
        self.m = {k:i for i,k in enumerate(inorder)}
        
        return self.helper(postorder, 0, len(postorder)-1)
        # NOTE: Start and end indices actually correspond to indices of inorder array
        
    def helper(self, postorder, start, end) -> Optional[TreeNode]:
        # base
        # if index reached 0 - we are done constructing the tree or when start >end
        if start > end: return None

        # find root in postorder
        rootVal = postorder[self.idx]
        # decrement the index 
        self.idx -= 1
        
        # create a TreeNode for rootVal
        root = TreeNode(rootVal)
        rootIdx = self.m[rootVal]
        
        # recursively call helper on right and left of post and in order arrays and assign it to root.left and root.right
        # order of left and right matters here as we are getting root for right side first from post order traversal
        # in the previous problem when we did pre-and-in order traversal, we used left and right, but here the order needs to be
        # right first then left
        # NOTE: Start and end indices actually correspond to indices of inorder array
        root.right = self.helper(postorder, rootIdx+1, end)
        root.left = self.helper(postorder, start, rootIdx-1)
        
        return root