'''
POSTORDER >>> Root at the end of list
Recursion should be first right and then left

Postorder ---> Left, Right, Root
So, we get the root from the end of the list, then do RIGHT traversal, and then LEFT traversal

-------------------
ROOT > RIGHT > LEFT
-------------------
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

## Brute Sources
class Solution:
    def buildTree(self, postorder: list[int], inorder: list[int]):
        '''
        TC: O(n^2); O(n)-for searching & O(n)-for recursion so O(n)* O(n) = O(n^2)
        AS: O(n^2)
        '''

        ## base condition
        if not postorder or not inorder:
            return None
        
        rootVal = postorder[-1] # Get the root
        root = TreeNode(rootVal) # Create the Tree Node

        # Get the index of the root from the inorder traversal
        for idx, element in enumerate(inorder):
            if element == rootVal:
                rootIdx = idx
                break

        # Get the inorder left
        inorder_left = inorder[:rootIdx]
        # Get the inorder right  
        inorder_right = inorder[rootIdx+1:]

        # Get the postorder left
        postorder_left = postorder[:len(inorder_left)]

        # Get the postorder right  
        postorder_right = postorder[len(inorder_left):-1]

        ## logic
        # Right Traversal first in post order
        root.right = self.buildTree(inorder_right, postorder_right)
        root.left = self.buildTree(inorder_left, postorder_left)

        return root
    
## Hashing and Two Pointer
class Solution:
    def buildTree(self, inorder: list[int], postorder: list[int]):
        '''
        TC: O(n); O(1)-for searching & O(n)-for recursion so O(1)* O(n) = O(n)
        AS: O(n)
        '''

        ## Put the inorder in HashMap
        inorder_map = {}
        for idx, element in enumerate(inorder):
            inorder_map[element] = idx
        
        postorder_idx = -1

        def helper(inorder_map, postorder, start, end):
            
            nonlocal postorder_idx

            ## base condition
            if start > end:
                return None
        
            rootVal = postorder[postorder_idx] # Get the root
            root = TreeNode(rootVal) # Create the Tree Node

            # Get the index of the root from the inorder map
            rootIdx = inorder_map[rootVal]

            # Decrement postorder_idx in each recursive call to move the root in postorder list
            postorder_idx -= 1


            ## logic
            # Right Traversal first in post order
            root.right = helper(inorder_map, postorder, start, rootIdx-1)
            root.left = helper(inorder_map, postorder, rootIdx+1, end)

            return root
        
        # helper(inorder_map, postorder, start, end) >>> start and end from the inorder list
        return helper(inorder_map, postorder, 0, len(inorder)-1)
    
