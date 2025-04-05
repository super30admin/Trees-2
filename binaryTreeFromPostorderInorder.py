from typing import List, Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time Complexity: O(3n * n) = O(n^2)
# Space Complexity: O(2n), for storing inleft, inright, preleft, and preright arrays
# Approach:
# We observe that the last element of the postorder array will always give us the root of the tree.
# Once we identify the root, we can identify the index of the root in the inorder array.
# All the elements to the left of this index, will give us the inorder list for the left sub-tree and all the elements to its right will give us the inorder list for the right sub-tree. Since in-order = left-root-right
# Similarly, we can generate postorder list for left and right sub-trees by copying the elements equivalent to the length of the inleft from next to the root and remainder of the elements respectively. Since pre-order = root-left-right
# We can recursively construct the right and left subtrees.
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Base case
        if len(postorder) == 0 or len(inorder) == 0:
            return

        # Identify the root from the postorder array
        rootVal = postorder[-1]
        # Identify the index of the root in the inorder array
        idx = -1
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                idx = i
                break

        # O(2n)
        # Generate the postorder and inorder arrays for the left and right sub-trees
        inright = inorder[idx+1:]
        inleft = inorder[:idx]
        postright = postorder[len(inleft):len(postorder)-1]
        postleft = postorder[:len(inleft)]

        # Construct root node
        root = TreeNode(rootVal)

        # building the right sub-tree
        # Attach the node returned to the right of the root
        root.right = self.buildTree(inright, postright)
        # building the left sub-tree
        # Attach the node returned to the left of the root
        root.left = self.buildTree(inleft, postleft)

        return root
    
# Time Complexity: O(n) where n is the number of nodes in the tree
# Space Complexity: O(n) for storing the hashmap.
# Approach:
# In the previous approach, there are following inefficiencies:
# 1. We are constructing new arrays for each node, which take O(n^2) time - we can overcome this by passing indices for start and end of the array.
# 2. We are finding the position of the root node in the inorder list in O(n) time - we can overcome this by using a hashmap
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Initializing the idx, to keep track of the index of the current root as a global variable
        self.idx = len(postorder)-1
        # Initializing and populating the hashmap - with values as keys and index as values for the inorder array
        hashMap = {}
        for i in range(len(inorder)):
            hashMap[inorder[i]] = i

        # Recursively building the right and left sub-trees
        def helper(start, end):
             # If the start and end pointers cross each other, it means we do not have any nodes for the sub-tree and so we return
            if start > end:
                return

            # Getting the value for the current root
            rootVal = postorder[self.idx]
            # Once we got the value of the root, we can decrement the idx to point to the next root
            self.idx -= 1
             # Getting the index of the root in the inorder array
            rootIdx = hashMap[rootVal]
            # Creating a new node with the value as rootVal
            root = TreeNode(rootVal)

            # Recursively building the right and left sub-trees
            # Here, we can only build the right sub-tree first, becasue the idx will always be pointing to the root for the right sub-tree
            root.right = helper(rootIdx+1, end)
            root.left = helper(start, rootIdx-1)
            # Finally, we return the root
            return root

        return helper(0, len(postorder)-1)