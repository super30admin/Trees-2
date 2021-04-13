# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        N = len(postorder)
        self.index = N-1
        
        # Index Map for constant time look up
        inorder_map = {}
        for index, elem in enumerate(inorder):
            inorder_map[elem] = index
        
        def helper(start=0, end=N-1):
            
            ### Base Case
            if end < start:
                return
            
            ### Logic
            
            # Process node which the index is pointing at
            node = TreeNode(postorder[self.index])
            self.index -= 1
            
            # Find its position in inorder_map
            split_index = inorder_map[node.val]
            
            # Build Right SubTree and append to node
            node.right = helper(split_index+1, end)
            
            # Build Left SubTree and append to node
            node.left = helper(start, split_index-1)
            
            # Return Node
            return node
        
        return helper()
        
### Complexity Analysis

# Time Complexity: O(N) --> N = Number of Nodes; We traverse through all the nodes to build the tree
# Space Comlexity: O(H) + O(N) --> H = Height of Tree; Stack Size occupied by recursive calls + Inorder Map Size