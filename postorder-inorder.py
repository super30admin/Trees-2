# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach: 
# Get the value of the root node from the postorder array (last element - left, right, root)
# Find the index of root element in inorder array
# Recursively construct the left and right subtrees using the inorder array

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # Hashmap to access index of root from inorder array in O(1)
        ino_map = {}
        for i in range(len(inorder)):
            ino_map[inorder[i]] = i
            
        
        def helper(p_start, p_end, i_start, i_end):
            # Base Case
            if p_start > p_end:
                return None
            if p_start == p_end:
                return TreeNode(postorder[p_start])
            
            # Root is the last element in postorder
            root_val = postorder[p_end]
            root_index = ino_map[root_val]
            
            # create a new treenode
            root = TreeNode(root_val)
            
            # Calculate number of elements in the left and right subtrees
            numleft = root_index - i_start
            numright = i_end - root_index
            
            # recursively construct the left and right subtrees
            root.left = helper(p_start,
                               p_start + numleft - 1,
                               i_start,
                               root_index - 1)
            root.right = helper(p_start + numleft,
                               p_end - 1,
                               root_index + 1,
                               i_end)
            return root
        
        return helper(0, len(postorder) - 1, 0, len(inorder) - 1)