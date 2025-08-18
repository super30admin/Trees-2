# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
# Your code here along with comments explaining your approach: The code reconstructs a binary tree from its inorder and postorder traversal arrays. It uses a hashmap (map_inorder) to quickly find the index of each node in the inorder array, then picks the last element of the postorder array as the root and recursively builds left and right subtrees. The helper function narrows down the inorder and postorder ranges to correctly assign subtree nodes until the entire tree is built.


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        map_inorder = dict()
        for index, val in enumerate(inorder):
            map_inorder[val] = index
        
        return self.helper(inorder, 0, len(inorder) - 1, postorder, 0, len(postorder) - 1, map_inorder)
    
    def helper(self, inorder, instart, inend, postorder, poststart, postend, map_inorder):
        if instart > inend and poststart > postend:
            return None
        
        rootVal = postorder[postend]
        root = TreeNode(rootVal)
        rootidx = map_inorder[rootVal]

        formula = postend - (inend - rootidx)

        root.left = self.helper(inorder, instart, rootidx - 1, postorder, poststart, formula - 1, map_inorder)
        root.right = self.helper(inorder, rootidx + 1, inend, postorder, formula, postend - 1, map_inorder)

        return root
