## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        """
        Time Complexity: O(N^2) in the worst case (e.g., a completely skewed tree). 
        At each level of the recursion, inorder.index() takes O(N) time to find the element, 
        and array slicing creates new lists which also takes O(N) time. Since this is done 
        for all N nodes, the worst-case time bounds to O(N^2). The average case for a 
        balanced tree is O(N log N).
        
        Space Complexity: O(N^2) in the worst case. 
        The recursive call stack can go as deep as N levels in a skewed tree (O(N) space). 
        Additionally, the array slicing (inorder[:mid], postorder[:mid], etc.) creates copies 
        of the lists at each recursive step, resulting in O(N^2) extra space overhead.
        """
        
        # Base case: if the arrays are empty, there are no nodes to construct for this subtree
        if not inorder or not postorder:
            return None
        
        # Logic: In a postorder traversal (Left, Right, Root), the last element is ALWAYS 
        # the root of the current tree/subtree. We extract it to create our root node.
        root = TreeNode(postorder[-1])
        
        # Logic: In an inorder traversal (Left, Root, Right), the root splits the array. 
        # Everything to the left of the root's index belongs to the left subtree, and 
        # everything to the right belongs to the right subtree.
        mid = inorder.index(postorder[-1])
        
        # Recursively construct the left subtree:
        # - Inorder left half: from start up to (but not including) the 'mid' index.
        # - Postorder left half: the first 'mid' elements correspond to the left subtree's nodes.
        root.left = self.buildTree(inorder[:mid], postorder[:mid])
        
        # Recursively construct the right subtree:
        # - Inorder right half: from 'mid + 1' to the end.
        # - Postorder right half: from 'mid' up to the second-to-last element 
        #   (since we exclude the very last element, which is the root we already processed).
        root.right = self.buildTree(inorder[mid + 1:], postorder[mid:-1])
        
        # Return the fully constructed root of the current subtree
        return root