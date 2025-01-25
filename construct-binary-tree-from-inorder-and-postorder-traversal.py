"""

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, 
construct and return the binary tree.

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]

Time Complexity: O(N) for Method 3, O(N^2) for Methods 1 & 2 due to slicing and index searches.  
Space Complexity: O(N) for Method 3 (hashmap + recursion stack), O(N^2) for Methods 1 & 2 (slicing copies).  

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# The approach reconstructs the binary tree from inorder and postorder traversals by identifying the root 
# (last element in postorder), finding its position in inorder, and recursively building left and right subtrees.  
# Method 1 & 2 slice lists, leading to higher space complexity, while Method 3 uses a hashmap for efficient lookups  
# and avoids excessive slicing by maintaining index boundaries.  


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        # method 1:

        if not inorder or not postorder:
            return None

        root = TreeNode(postorder[-1])
        mid = inorder.index(postorder[-1])

        root.left = self.buildTree(inorder[:mid], postorder[:mid])
        root.right = self.buildTree(inorder[mid+1:], postorder[mid:-1])

        return root

        # method 2:
        
        if not inorder:
            return None

        root = TreeNode(postorder.pop())
        mid = inorder.index(root.val)

        root.right = self.buildTree(inorder[mid+1:], postorder)
        root.left = self.buildTree(inorder[:mid], postorder)

        return root

        # method 3:

        idx_map = {v: i for i, v in enumerate(inorder)}

        def helper(l, r):
        
            if l > r:
                return None
            
            val = postorder.pop()
            root = TreeNode(val)
            mid = idx_map[val]

            root.right = helper(mid + 1, r)
            root.left = helper(l, mid-1)
            
            return root
        
        return helper(0, len(inorder) - 1)
