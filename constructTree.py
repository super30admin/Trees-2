// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        to_inorder_idx = {v: k for k, v in enumerate(inorder)}
        
        def helper(pos_start, in_start, in_end):
            # Exit condition
            if pos_start > len(postorder) - 1 or in_start > in_end:
                return
            
            # Find the root node, which, by definition of postorder traversal, 
            # is the last node in the current subtree.
            root_idx = pos_start + (in_end - in_start)
            val = postorder[root_idx]
            node = TreeNode(val=val)
            mid_idx = to_inorder_idx[val]
            
            # Calcualte the size of the left subtrees and right subtrees.
            left_size = mid_idx - in_start
            right_size = in_end - in_start - left_size
            node.left = helper(pos_start=pos_start, in_start=in_start, 
                               in_end=mid_idx - 1)
            node.right = helper(pos_start=pos_start + left_size, 
                                in_start=mid_idx + 1, 
                                in_end=in_end)
            return node
        
        return helper(pos_start=0, in_start=0, in_end=len(inorder) - 1)