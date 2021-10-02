# Binary_tree_post_inorder
# time complexity: O(N)
# space complexity: O(N)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : NA

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        postorder = deque(postorder)
        def helper(inorder, postorder):
            if inorder:
                root_val = postorder.pop()
                index = inorder.index(root_val)
                node = TreeNode(root_val)
                left_arr = inorder[:index]
                right_arr = inorder[index+1:]
                node.right = helper(right_arr, postorder)
                node.left = helper(left_arr, postorder)
                return node
            
        return helper(inorder, postorder)